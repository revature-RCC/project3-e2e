package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class MainPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "register-btn")
    WebElement registerBtn;

    @FindBy(id = "login-btn")
    WebElement loginBtn;

    @FindBy(id = "product#16")
    WebElement product;

    @FindBy(id = "searchInput")
    WebElement searchInput;

    @FindBy(id = "searchButton")
    WebElement searchBtn;

    @FindBy(id = "cart-btn")
    WebElement cartBtn;

    @FindBy(id = "products")
    WebElement productsContainer;

    public MainPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public String checkProducts(){
        List<WebElement> titleList = this.productsContainer.findElements(By.className("mediumFont"));
        return titleList.get(0).getText();

    }

    public boolean checkSearch(String search, String productTitle){
        return productTitle.toLowerCase().contains(search.toLowerCase());
    }

    public void clickRegisterBtn(){
        this.registerBtn.click();
    }

    public void clickLoginBtn(){
        this.loginBtn.click();
    }

    public void search(String searchInput){
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        this.searchInput.sendKeys(searchInput);
        this.searchBtn.click();


        this.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("products"),productList.size()));
    }

    public void clickProduct(){

        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        productList.get(0).click();

    }

    public String getId(){
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        return productList.get(0).getAttribute("id").split("#")[1];
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void verifyRegisterRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/register"));
    }

    public void verifyLoginRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
    }

    public void verifyCartRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/cart"));
    }

    public void verifyProductRedirect(String id){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/product/"+id));
    }

    public void clickCartBtn(){
        this.cartBtn.click();
    }


}