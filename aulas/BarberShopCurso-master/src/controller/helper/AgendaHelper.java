package controller.helper;

import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Cliente;
import model.Servico;

public class AgendaHelper implements IHelper {

    private final Agenda view;

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

    public void preencherClientes(ArrayList<Cliente> clientes) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxCliente().getModel();

        for (Cliente cliente : clientes) {

            comboBoxModel.addElement(cliente); //aqui esta o truque

        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxServico().getModel();

        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);

        }
    }

    public Cliente obterCliente() {
        return (Cliente) view.getJComboBoxCliente().getSelectedItem();
    }

    public Servico obterServico() {
        return (Servico) view.getJComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTextValor().setText(valor + "");
    }

    @Override
    public Agendamento obterModelo() {

        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String dataHora = data + " " + hora;
        String oberservacao = view.getTextObservacao().getText();

        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, oberservacao);
        return agendamento;

        //new Agendamento();
    }

    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");

    }

}
