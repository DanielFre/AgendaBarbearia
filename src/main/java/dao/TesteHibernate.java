/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Model.DAO.UsuarioDAO;
import Model.Usuario;
import dao.JPAUtil;
import javax.persistence.EntityManager;


/**
 *
 * @author tiago
 */
public class TesteHibernate {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

            Usuario usuario = new Usuario("daniel", "123");
            new UsuarioDAO(em).insert(usuario);

        em.getTransaction().commit();
        em.close();

    }
}
