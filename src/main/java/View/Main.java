/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Clientes;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author danie
 */
public class Main {
    
    public static void main(String[] args) {
        
        Servico servico = new Servico(1, "Barba", 30);
        System.out.println(servico.getDescricao());
        
        Clientes cliente = new Clientes(1, "ClienteDaniel", "Av. Flores da Cunha, 701", "98789-122");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario("Daniel", "123");
//        System.out.println(usuario.getNome());
        

        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "25/05/2022 22:00");
        System.out.println(agendamento.getCliente().getNome());
    }
    
}
