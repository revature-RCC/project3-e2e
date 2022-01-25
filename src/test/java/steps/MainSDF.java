package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import poms.MainPOM;

public class MainSDF {

    MainPOM mainPOM;

    String id;

    String color;

    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("A user is on the main page")
    public void a_user_is_on_the_main_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/");

        this.mainPOM = new MainPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.mainPOM.getCurrentUrl());
    }
    @When("A user clicks on the register button")
    public void a_user_clicks_on_the_register_button() {
        this.mainPOM.clickRegisterBtn();
    }

    @Then("The user will be redirected to register page")
    public void the_user_will_be_redirected_to_register_page() {
        this.mainPOM.verifyRegisterRedirect();

        Assertions.assertEquals("http://localhost:4200/register",this.mainPOM.getCurrentUrl());

    }

    @When("A user clicks on the login button")
    public void a_user_clicks_on_the_login_button() {
        this.mainPOM.clickLoginBtn();
    }

    @Then("The user will be redirected to login page")
    public void the_user_will_be_redirected_to_login_page() {
        this.mainPOM.verifyLoginRedirect();
        Assertions.assertEquals("http://localhost:4200/login",this.mainPOM.getCurrentUrl());
    }

    @When("A user clicks on a product")
    public void a_user_clicks_on_a_product() {
        this.id = this.mainPOM.getId();
        this.mainPOM.clickProduct();
    }
    @Then("The user will be redirected to the product page")
    public void the_user_will_be_redirected_to_the_product_page() {
        this.mainPOM.verifyProductRedirect(this.id);
        Assertions.assertEquals("http://localhost:4200/product/"+this.id,this.mainPOM.getCurrentUrl());
    }

    @When("A user inputs a search in the search bar")
    public void a_user_inputs_a_search_in_the_search_bar() {
        this.mainPOM.search("java");
    }

    @Then("The user will be able to see searched items")
    public void the_user_will_be_able_to_see_searched_items() {
        String product = this.mainPOM.checkProducts();
        Assertions.assertTrue(this.mainPOM.checkSearch("java",product));

    }

    @When("A user clicks on the cart icon")
    public void a_user_clicks_on_the_cart_icon() {
        this.mainPOM.clickCartBtn();
    }

    @Then("The user will be redirected to the cart page")
    public void the_user_will_be_redirected_to_the_cart_page() {
        this.mainPOM.verifyCartRedirect();
        Assertions.assertEquals("http://localhost:4200/cart",this.mainPOM.getCurrentUrl());
    }

    @When("The user clicks on the dark mode button")
    public void the_user_clicks_on_the_dark_mode_button() {
        color = this.mainPOM.checkThemeColor();
        this.mainPOM.clickDarkModeBtn();
    }
    @Then("Then the color scheme will change")
    public void then_the_color_scheme_will_change() {
        Assertions.assertNotEquals(color, this.mainPOM.checkThemeColor());
    }

    @Then("The user can see sale tags and sale prices")
    public void the_user_can_see_sale_tags_and_sale_prices() {
        this.mainPOM.waitForSales();
        Assertions.assertTrue(this.mainPOM.checkSales());
    }
}
