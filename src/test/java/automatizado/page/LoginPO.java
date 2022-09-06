package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;
    /**
     * Construtor padrão para criação de uma nova instância de uma página de login.
     * @param driver Driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    /**
     * Método que realiza a tentativa de login
     * @param email parâmetro usado para tentativa de login
     * @param senha parâmetro usado para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email); 
        escrever(inputSenha, senha); 

        buttonEntrar.click();
    }
    
}
