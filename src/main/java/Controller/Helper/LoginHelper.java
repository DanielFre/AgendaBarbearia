/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author danie
 */
public class LoginHelper implements IHelper{

    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }

    public Usuario obterModelo() {
        String usuario = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        Usuario modelo = new Usuario(0, usuario, senha);
        return modelo;
    }

    public void setarModelo(Usuario modelo) {
        String usuario = modelo.getUsuario();
        String senha = modelo.getSenha();

        view.getTextUsuario().setText(usuario);
        view.getTextSenha().setText(senha);

    }

    public void limparTela() {
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
}
