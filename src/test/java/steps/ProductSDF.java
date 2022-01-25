package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;
import poms.MainPOM;
import poms.ProductPOM;

public class ProductSDF {

    ProductPOM productPOM;


    @Given("a user is on the product page")
    public void a_user_is_on_the_product_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/product/16");
        this.productPOM = new ProductPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/product/16", this.productPOM.getCurrentUrl());
    }
    @When("a user increments the quantity of the product")
    public void a_user_increments_the_quantity_of_the_product() {
        this.productPOM.incQuantity();
    }
    @Then("a user can see the quantity increases")
    public void a_user_can_see_the_quantity_increases() {

        Assertions.assertEquals("2", this.productPOM.getQuantity());

    }

    @When("a user clicks on the add to cart button")
    public void a_user_clicks_on_the_add_to_cart_button() {
        this.productPOM.clickAddToCart();
    }


    @Then("a error message appears and the user is redirected to the login page")
    public void a_error_message_appears_a_user_is_redirected_to_the_login_page() {
        Assertions.assertEquals("Error! Unauthorized", this.productPOM.getErrorMessage());
        this.productPOM.waitForSuccessfulLoginRedirect();
        Assertions.assertEquals("http://localhost:4200/login", this.productPOM.getCurrentUrl());
    }

    @Then("the user will be notified with a message")
    public void the_user_will_be_notified_with_a_message() {
        Assertions.assertEquals("Added to Cart",this.productPOM.getMessage());
    }

    @When("a user clicks the go to cart button")
    public void a_user_clicks_the_go_to_cart_button() {
        this.productPOM.clickGoToCart();
    }

    @Then("the user will be redirected to the cart page")
    public void the_user_will_be_redirected_to_the_cart_page() {
        this.productPOM.waitForSuccessfulCartRedirect();
        Assertions.assertEquals("http://localhost:4200/cart", this.productPOM.getCurrentUrl());
    }


}