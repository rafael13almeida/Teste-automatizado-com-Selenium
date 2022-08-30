package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;

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

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailIncorretoeSenhaIncorreta() {

        loginPage.executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();
        String retorno = "E-mail ou senha inválidos";
        assertEquals(mensagem, retorno);
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoeSenhaIncorreta() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();
        String retorno = "E-mail ou senha inválidos";
        assertEquals(mensagem, retorno);
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoeSenhaCorreta() {

        loginPage.executarAcaoDeLogar("teste", "admin@123");

        String mensagem = loginPage.obterMensagem();
        String retorno = "E-mail ou senha inválidos";
        assertEquals(mensagem, retorno);
    }

    @Test
    public void TC007_DeveLogarNoSistemaComEmailCorretoeSenhaCorreta() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }
}
