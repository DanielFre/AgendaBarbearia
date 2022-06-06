/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Model.Agendamento;

/**
 *
 * @author daniel.frey
 */
public class Correio {

    public void notificarPorEmail(Agendamento agendamento) {

        String emailFormatado = formarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        //uso da classe de e-mail
        Email email = new Email("Agendamento Barbearia JP", emailFormatado, destinatario);
        email.enviar();
    }

    private String formarEmail(Agendamento agendamento) {

        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataagendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();

        return ("Ola " 
                + nomeCliente + "\n Seu agendamento para "
                + servico + " esta marcado para o dia "
                + dataagendamento + " as "
                + horaAgendamento + " O preco para voce fica R$" 
                + valor + "\n Forte Abraco!!");

    }

}
