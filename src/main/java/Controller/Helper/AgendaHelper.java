/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Clientes;
import Model.Servico;
import View.Agenda;
import View.Loading;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class AgendaHelper implements IHelper{

    private final Agenda view;
    private final Loading loading = new Loading();
    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {

        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);

        //percorrer a lista preenchendo o table model
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }

    public void preencherClientes(ArrayList<Clientes> clientes) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboboxCliente().getModel();

        for (Clientes cliente : clientes) {
            comboBoxModel.addElement(cliente); //aqui esta o truque
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboboxServico().getModel();

        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico); //aqui esta o truque
        }
    }
    
    public Clientes obterCliente() {
        return (Clientes) view.getjComboboxCliente().getSelectedItem();

    }

    public Servico obterServico() {
        return (Servico) view.getjComboboxServico().getSelectedItem();

    }

    public void setarValor(float valor) {
        view.getTextValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {
        
       String  idString = view.getTextId().getText();
       int id  = Integer.parseInt(idString);
       Clientes cliente = obterCliente();
       Servico servico = obterServico();
       String obterValor = view.getTextValor().getText();
       float valor = Float.parseFloat(obterValor);
       String data = view.getTextFormatedData().getText();
       String hora = view.getTextFormatedHora().getText();
       String dataHora = data + " " + hora;
       String observacao = view.getTextObservacao().getText();
       
       Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
       return agendamento;       
    }

    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }
    
      public void iniciarLoading() {
        this.loading.setVisible(true);
    }

    public void closeLoading() {
        this.loading.dispose();
    }
}
