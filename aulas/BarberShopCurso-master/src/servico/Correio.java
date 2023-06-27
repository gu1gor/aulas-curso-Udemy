package servico;

import model.Agendamento;

public class Correio {

    public void notificarPorEmail(Agendamento agendamento) {

        String emailFormatado = formarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();

        //Uso da classe de email
        Email email = new Email("Agendamento BarberShop", emailFormatado, destinatario);
        email.enviar();

    }

    private String formarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();

        return "Olá" + nomeCliente + " Vai dar tapa no visu... Seu agendamento para "
                + servico + ", esta marcado para o dia " + dataAgendamento
                + " às " + horaAgendamento + " O preço para você sai baratinho fica R$" + valor + " Forte Abraço!!";

    }

}
