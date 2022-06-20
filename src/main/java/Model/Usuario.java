///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Model;
//
//
//
//
///**
// *
// * @author danie
// */
//public class Usuario extends Pessoa{
//    
//    private String senha;
//    private String nivelDeAcesso;
//
//    public Usuario(int id, String nome, String senha ) {
//        super(id, nome);
//        this.senha = senha;
//    }
//
//    public Usuario(int id, String nome, String senha, String nivelDeAcesso) {
//        super(id, nome);
//        this.senha = senha;
//        this.nivelDeAcesso = nivelDeAcesso;
//    }
//
//    public Usuario( int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg, String senha, String nivelDeAcesso) {
//        super(id, nome, sexo, dataNascimento, telefone, email, rg);
//        this.senha = senha;
//        this.nivelDeAcesso = nivelDeAcesso;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
//
//    public String getNivelDeAcesso() {
//        return nivelDeAcesso;
//    }
//
//    public void setNivelDeAcesso(String nivelDeAcesso) {
//        this.nivelDeAcesso = nivelDeAcesso;
//    } 
//   
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author daniel.frey
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String senha;
//    private String email;

    public Usuario(int id, String usuario, String senha) {
        this.id = id;
        this.senha = senha;
        this.usuario = usuario;
    }

    public Usuario(String usuario, String senha) {
        this.senha = senha;
        this.usuario = usuario;
    }

//    public Usuario(String usuario, String senha, String email) {
//        this.usuario = usuario;
//        this.senha = senha;
//        this.email = email;
//    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
