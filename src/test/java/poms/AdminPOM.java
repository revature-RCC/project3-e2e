package poms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPOM {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "productName")
    WebElement nameInput;

    @FindBy(id = "productDescription")
    WebElement descInput;

    @FindBy(id = "productPrice")
    WebElement priceInput;

    @FindBy(id = "salePrice")
    WebElement saleInput;

    @FindBy(id = "product-inventory")
    WebElement stockInput;

    @FindBy(id = "productImageInput")
    WebElement imageInput;

    @FindBy(tagName = "button")
    WebElement createProductBtn;

    @FindBy(id = "products")
    WebElement productsContainer;

    @FindBy(id = "update-btn")
    WebElement updateBtn;

    public AdminPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void clickCreateProductBtn(){
        this.createProductBtn.click();
    }

    public void enterProductName(String productName){
        this.nameInput.sendKeys(productName);
    }

    public void enterProductDescription(String productDescription){
        this.descInput.sendKeys(productDescription);
    }

    public void enterProductRegularPrice(Double productRegularPrice){
        this.priceInput.sendKeys("Pictures of Uranus");
    }

    public void enterProductSalesPrice(Double productSalesPrice){
        this.saleInput.sendKeys("Pictures of Uranus");
    }

    public void enterProductStock(Integer productStock){
        this.stockInput.sendKeys("Pictures of Uranus");
    }

    public Boolean checkEmptyName(){
        return this.nameInput.getText().isEmpty();
    }

    public Boolean checkEmptyDescription(){
        return this.descInput.getText().isEmpty();
    }

    public Boolean checkEmptyRegularPrice(){
        return this.priceInput.getText().isEmpty();
    }

    public Boolean checkEmptySalePrice(){
        return this.saleInput.getText().isEmpty();
    }

    public Boolean checkEmptyStock(){
        return this.stockInput.getText().isEmpty();
    }

    public Boolean checkEmptyImage(){
        return this.imageInput.getText().isEmpty();
    }

    public void waitHere(){
        try{
            this.wait.until(ExpectedConditions.alertIsPresent());
        } catch(TimeoutException e){}
    }

    public String getErrorMessage(){
        this.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = this.driver.switchTo().alert();
        return alert.getText();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }


    public void clickUpdateBtn(){
        this.updateBtn.click();
    }




}
