///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Model.DAO;
//
//import Model.Usuario;
//import java.util.ArrayList;
//
///**
// *
// * @author tiago
// */
//public class UsuarioDAO {
//    
//    /**
//     * Insere um usuario dentro do banco de dados
//     * @param usuario exige que seja passado um objeto do tipo usuario
//     */
//    public void insert(Usuario usuario){
//        Banco.usuario.add(usuario);
//    }
//    
//    /**
//     * Atualiza um Objeto no banco de dados
//     * @param usuario
//     * @return 
//     */
//    public boolean update(Usuario usuario){
//        
//        for (int i = 0; i < Banco.usuario.size(); i++) {
//            if(idSaoIguais(Banco.usuario.get(i),usuario)){
//                Banco.usuario.set(i, usuario);
//                return true;
//            }
//        }
//        return false;      
//
//    }
//    
//    /**
//     * Deleta um objeto do banco de dados pelo id do usuario passado
//     * @param usuario
//     * @return 
//     */
//    public boolean delete(Usuario usuario){
//        for (Usuario usuarioLista : Banco.usuario) {
//            if(idSaoIguais(usuarioLista,usuario)){
//                Banco.usuario.remove(usuarioLista);
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    /**
//     * Retorna um arraylist com todos os usuarios do banco de dados
//     * @return uma lista com todos os registros do banco
//     */
//    public ArrayList<Usuario> selectAll(){
//        return Banco.usuario;
//    }
//    
//    /**
//     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado como parâmetro no banco, para considerar sao usado nome e senha
//     * @param usuario
//     * @return Usuario encontrado no banco de dados
//     */
//    public Usuario selectPorNomeESenha(Usuario usuario){
//        for (Usuario usuarioLista : Banco.usuario) {
//            if(nomeESenhaSaoIguais(usuarioLista,usuario)){
//                return usuarioLista;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
//     * @param usuario
//     * @param usuarioAPesquisar
//     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
//     */
//    private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
//        return usuario.getNome().equals(usuarioAPesquisar.getNome()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
//    }
//
//    /**
//     * Compara se dois objetos tem a propriedade id igual
//     * @param usuario
//     * @param usuarioAComparar
//     * @return verdadeiro caso os id forem iguais e falso se nao forem
//     */
//    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
//        return usuario.getId() ==  usuarioAComparar.getId();
//    }
//    
//    
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 *
 * @author daniel.frey
 */
public class UsuarioDAO {

    private final EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public Usuario insert(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    public Usuario update(Usuario usuario) {
        em.merge(usuario);
        em.persist(usuario);
        return usuario;
    }

    public Usuario insertOrUpdate(Usuario usuario) {
        if (usuario.getId() > 0) {
            return this.update(usuario);
        }
        return insert(usuario);
    }

    public void delete(Usuario usuario) {
        em.merge(usuario);
        em.remove(usuario);
    }

    public Usuario selectPorId(Usuario usuario) {
        return em.find(Usuario.class, usuario);
    }

    public List<Usuario> selectAll() {
        String jpql = "select u from Usuario as u";
        Query query = em.createQuery(jpql);
        return retornarListaComBaseNaConsulta(query);
    }

    private List<Usuario> retornarListaComBaseNaConsulta(Query query) {
        List<Usuario> usuarios;
        try {
            usuarios = query.getResultList();
        } catch (NoResultException e) {
            usuarios = new ArrayList<Usuario>();
        }
        return usuarios;
    }

    public boolean verificaSeExisteUsuarioEsenhaNoBanco(Usuario usuarioNovo) {

        String jpql = "select u from Usuario as u "
                + "where "
                + "u.usuario = :pUsuario and u.senha = :pSenha";

        Query query = em.createQuery(jpql);

        query.setParameter("pUsuario", usuarioNovo.getUsuario());
        query.setParameter("pSenha", usuarioNovo.getSenha());

         return !retornarListaComBaseNaConsulta(query).isEmpty();
    }
}
