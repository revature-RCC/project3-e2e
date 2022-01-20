package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(className = "btn btn-primary")
    WebElement loginBtn;

    /*@FindBy(className = "error-message-container")
    WebElement messageElem;*/

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void submitLogin(){
        this.loginBtn.click();
    }

}
