package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.LoginPO;

public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;

    // private void executarAcaoDeLogar(String email, String senha) {
    //     loginPage.escrever(loginPage.inputEmail, email); 
    //     loginPage.escrever(loginPage.inputSenha, senha); 

    //     // loginPage.buttonEntrar.click();
    // }

    @BeforeClass
    public static void prepararTeste() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();
        String retorno = "Informe usuário e senha, os campos não podem ser brancos.";
        assertEquals(mensagem, retorno);
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoeSenhaVazia() {

        loginPage.executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagem();
        String retorno = "Informe usuário e senha, os campos não podem ser brancos.";
        assertEquals(mensagem, retorno);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioeSenhaIncorreta() {

        loginPage.executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();
        String retorno = "Informe usuário e senha, os campos não podem ser brancos.";
        assertEquals(mensagem, retorno);
    }
}
