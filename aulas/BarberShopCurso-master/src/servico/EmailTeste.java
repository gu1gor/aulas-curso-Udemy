package servico;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailTeste {

    public static void main(String[] args) {

        Email email = new Email("Assunto da barbearia",
                "Mensagem padrão do Sistema da Barbearia",
                "guuh009@gmail.com");

        email.enviar();

    }

}
