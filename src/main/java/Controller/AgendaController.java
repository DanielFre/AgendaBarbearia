/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Clientes;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Servico.Correio;
import View.Agenda;
import View.Loading;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;
//    private final Loading loading = new Loading();

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualizaTabela() {

        //buscar uma lista com os agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();

        //exibir essa lista na view
        helper.preencherTabela(agendamentos);

    }

    public void atualizaCliente() {
        //buscar cleinte no banco de dados 
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Clientes> clientes = clienteDAO.selectAll();

        //exibir  cliente no combobox clientes
        helper.preencherClientes(clientes);

    }

    public void atualizaServico() {
        //buscar cleinte no banco de dados 
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();

        //exibir  cliente no combobox clientes
        helper.preencherServicos(servicos);
    }

    public void atualizaValor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }

    public void agendar() {
        helper.iniciarLoading();
        // busca objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        //salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        //envia email de notificação de confirmação de agendamento
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);
        //inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
        helper.closeLoading();
    }
}
