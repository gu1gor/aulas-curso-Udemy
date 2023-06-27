package controller;

import View.Login;
import View.MenuPrincipal;
import controller.helper.LoginHelper;
import model.DAO.UsuarioDAO;
import model.Usuario;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    
    public void entrarNoSistema(){
        
        //Pegar um Usuario da View
        Usuario usuario = helper.obterModelo();
        
        
        
        //Pegar um Usuario da View
        
        UsuarioDAO usuarioDAO = new UsuarioDAO(); 
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        //Se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco, direcionar para menu principal
        //Senão mostrar uma mensagem ao usuario "Usuario ou senha invalidos"         
        if(usuarioAutenticado != null){
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                this.view.dispose();    
                
        }else{
             view.exibeMensagem("Usuario ou senha invalidos");
        }
            
                

                //Pesquisar Usuário no Banco
        
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados.");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
}
