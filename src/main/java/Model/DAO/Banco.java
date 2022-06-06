/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Agendamento;
import Model.Clientes;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Banco {

    public static ArrayList<Usuario> usuario;
    public static ArrayList<Clientes> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;

    public static void inicia() {

        //Instancia os Objetos
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<Clientes>();
        servico = new ArrayList<Servico>();
        agendamento = new ArrayList<Agendamento>();

        //criando elementos
        Usuario usuario1 = new Usuario(1, "barbeiro", 'M', "09/05/1996", "30212121", "barbeiro@barbershop.com", "521454123", "barbeiro", "administrador");
        Usuario usuario2 = new Usuario(2, "estagiario", 'M', "09/05/1996", "30212122", "estagiario@barbershop.com", "451244123", "estagiario", "funcionario");
        Usuario usuario3 = new Usuario(3, "admin", 'M', "09/011/1996", "30212121", "daniel.f@sou.unijui.edu.br", "521454123", "admin", "administrador");

        Clientes cliente1 = new Clientes(1, "Daniel Frey", 'M', "11/09/1996", "3021212478", "daniel._.frey@hotmail.com", "845713647", "Rua marechal 1023 Canudos NH", "933000874");
        Clientes cliente2 = new Clientes(2, "Judite Oliveira", 'F', "30/08/1994", "30212127", "juditeoliveirapet@gmail.com", "5142487745", "Rua campo bom 78 Centro NH", "93300045");
        Clientes cliente3 = new Clientes(3, "Paulo Ricado", 'M', "24/04/1997", "30212128", "pauloricardopet@gmail.com", "78451458", "Rua Tres Irmaos 30 Vila Nova - NH", "933007496");
        Clientes cliente4 = new Clientes(4, "Neymar Santos", 'M', "20/08/1995", "30212130", "neymarsantospet@gmail.com", "2745487", "Rua Lombardi 40 Canudos NH", "93300748");
        Clientes cliente5 = new Clientes(5, "Debruine Pipoqueiro", 'M', "13/09/1992", "30212131", "debruinepet@gmail.com", "4742487", "Rua pedro quaresma 784 Canudos Belgica", "933000847");
        Clientes cliente6 = new Clientes(6, "Matuidi Pareira", 'M', "17/08/1994", "302122324", "matuidipet@gmail.com", "78512457", "Rua champions 10 Kephas Franca", "933000782");
        Clientes cliente7 = new Clientes(7, "Marta de Souza", 'F', "25/03/1993", "302121292", "martasouzapet@gmail.com", "4658237314", "Rua tesla 215 Canudos NH", "93352012");
        Clientes cliente8 = new Clientes(8, "Aline Ferrari", 'F', "04/03/1990", "302121451", "alineferraripet@gmail.com", "8475123687", "Rua hyrule 32 Canudos NH", "9334714747");
        Clientes cliente9 = new Clientes(9, "Samuel Coltinho", 'M', "09/02/1998", "302121189", "samuelcoltinhopet@gmail.com", "74595142487", "Rua floresta 12 Canudos NH", "9330046364");
        Clientes cliente10 = new Clientes(10, "Felipe Luis", 'M', "12/06/1999", "3021212478", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH", "933000874");
        Clientes cliente11 = new Clientes(11, "Alan Figueiredo", 'M', "30/01/1995", "30212126", "tiagoluz.h607@gmail.com", "5142487", "Rua jaboti 35 Canudos NH", "93300012");

        Servico servico1 = new Servico(1, "Corte Simples", 40);
        Servico servico2 = new Servico(2, "Corte Degrade", 45);
        Servico servico3 = new Servico(3, "Barba Simples", 15);
        Servico servico4 = new Servico(4, "Barba Desenhada", 25);
        Servico servico5 = new Servico(5, "Sombrancelhas", 10);
        Servico servico6 = new Servico(6, "Penteados", 10);
        Servico servico7 = new Servico(7, "Core + Barba", 70);

        Agendamento agendamento1 = new Agendamento(1, cliente11, servico2, 30, "14/07/2022 09:30");
        Agendamento agendamento2 = new Agendamento(2, cliente3, servico4, 40, "14/07/2022 10:00");
        Agendamento agendamento3 = new Agendamento(3, cliente4, servico1, 18, "14/07/2022 10:30");

        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);        
        usuario.add(usuario3);


        cliente.add(cliente1);
        cliente.add(cliente2);
        cliente.add(cliente3);
        cliente.add(cliente4);
        cliente.add(cliente5);
        cliente.add(cliente6);
        cliente.add(cliente7);
        cliente.add(cliente8);
        cliente.add(cliente9);
        cliente.add(cliente10);
        cliente.add(cliente11);

        servico.add(servico1);
        servico.add(servico2);
        servico.add(servico3);
        servico.add(servico4);
        servico.add(servico5);
        servico.add(servico6);
        servico.add(servico7);

        agendamento.add(agendamento1);
        agendamento.add(agendamento2);
        agendamento.add(agendamento3);

    }

}
