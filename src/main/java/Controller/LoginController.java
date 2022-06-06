/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author danie
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void entrarNoSistema() {

        // pegar o usuario da view
        Usuario usuario = helper.obterModelo();

        //pesquisar usuario no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

        if (usuarioAutenticado != null) { // se tudo ok direciona para o menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {        //  senão mostrar alerta informando "usuario ou senha inválidos"

            view.exibeMensagem("Usuário e/ou senha inválidos!");
        }
    }

    public void fizTarefa() {

        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o Fiz Tarefa");

    }

}
