package automatizado.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {
    
    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTeste() {

        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001() {

        googlePage.pesquisar("github.com");;

        String resultado = googlePage.resultadoPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002() {

        googlePage.pesquisar(" /rafael13almeida");;

        String resultado = googlePage.resultadoPesquisa();

        assertTrue(resultado, resultado.contains("resultados"));
    }

}
