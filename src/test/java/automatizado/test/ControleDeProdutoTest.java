package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControleDeProdutoTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;
    
    @BeforeClass
    public static void prepararTeste() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        
        controleProdutoPage = new ControleDeProdutoPO(driver);  
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_DeveAbrirModalParaCadastroAoClicarNoButaoCriar() {
        controleProdutoPage.buttonAdicionar.click();
        // TODO: Remover esse clique assim que o sistema for corrigido
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();
    }

    @Test
    public void TC002_NaoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        controleProdutoPage.buttonAdicionar.click();

        controleProdutoPage.cadastrarProduto("0001", "Entendendo Algoritmos", 1, 25.90, "");;

        String mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }
}
