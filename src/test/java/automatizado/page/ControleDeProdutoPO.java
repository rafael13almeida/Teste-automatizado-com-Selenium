package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutoPO extends BasePO{

    @FindBy(id = "#btn-adicionar")
    private WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    private WebElement LinkVoltar;
    
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
        
    }

    
}
