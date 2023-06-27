package view;

import java.text.ParseException;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        
        String nome = "Mendes";
        System.out.println(nome);
        
        Servico servico = new Servico(1, "barba", 30);
        
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Tiago", "Rua teste", "92531214545");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1, "barbeiro", "senha");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "30/06/2022 09:15");
        System.out.println(agendamento.getCliente().getNome());
        
        
    }
    
    
}
