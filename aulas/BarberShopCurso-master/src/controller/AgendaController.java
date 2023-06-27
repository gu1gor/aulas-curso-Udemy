package controller;

import View.Agenda;
import controller.helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.DAO.AgendamentoDAO;
import static model.DAO.Banco.agendamento;
import model.DAO.ClienteDAO;
import model.DAO.ServicoDAO;
import model.Servico;
import servico.Correio;

public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
    
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela() {

        //Buscar uma lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();

        //exibir lista na view
        helper.preencherTabela(agendamento);
        
    }
    
    public void atualizaCliente() {
        //Buscar Clientes do Banco de Dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> cliente = clienteDAO.selectAll();

        //Exibir Clientes no Combobox cliente
        helper.preencherClientes(cliente);
        
    }
    
    public void atualizaServico() {
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
        
    }
    
    public void atualizaValor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar() {
        //Buscar Objeto Agendamento da Tela
        Agendamento agendamento = helper.obterModelo();
        // Salvar o Objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);

        //Inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
        
    }
    
}
