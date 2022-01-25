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

public class MainPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "register-btn")
    WebElement registerBtn;

    @FindBy(id = "login-btn")
    WebElement loginBtn;

    @FindBy(id = "searchInput")
    WebElement searchInput;

    @FindBy(id = "searchButton")
    WebElement searchBtn;

    @FindBy(id = "cart-btn")
    WebElement cartBtn;

    @FindBy(id = "products")
    WebElement productsContainer;

    @FindBy(tagName = "a")
    List<WebElement> anchors;

    @FindBy(tagName = "html")
    WebElement theme;

    @FindBy(className = "oldPrice")
    List<WebElement> oldPrice;

    @FindBy(className = "saleRibbon")
    List<WebElement> saleRibbon;

    public MainPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void waitForSales(){
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("oldPrice"), 0));
    }

    public Boolean checkSales(){
        if(this.saleRibbon.isEmpty() && this.oldPrice.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public void clickDarkModeBtn(){
        this.anchors.get(3).click();
    }

    public String checkThemeColor(){
        if(this.theme.getAttribute("style").contains("black")) {
            return "black";
        } else {
            return "white";
        }
    }

    public String checkProductTitle(){
        List<WebElement> titleList = this.productsContainer.findElements(By.className("mediumFont"));
        return titleList.get(0).getText();
    }

    public String checkProductDescription(){
        List<WebElement> descriptionList = this.productsContainer.findElements(By.className("productDescription"));
        return descriptionList.get(0).getText();
    }

    public boolean checkSearch(String search, String productTitle, String productDescription){
        return productTitle.toLowerCase().contains(search.toLowerCase()) || productDescription.toLowerCase().contains(search.toLowerCase());
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
