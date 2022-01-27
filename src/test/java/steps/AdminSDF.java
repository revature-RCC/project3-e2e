package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.AdminPOM;

public class AdminSDF {

    AdminPOM adminPOM;

    @Given("An Admin is on the add product page")
    public void an_admin_is_on_the_add_product_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/admin-new-product");

        this.adminPOM = new AdminPOM(DriverSingleton.getInstance());

        Assertions.assertEquals("http://localhost:4200/admin-new-product", this.adminPOM.getCurrentUrl());
    }

    @When("The Admin submits the form without adding a name")
    public void the_admin_submits_the_form_without_adding_a_name() {
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the name field")
    public void the_form_produces_an_error_message_on_the_name_field() {
        this.adminPOM.waitHere();
        Assertions.assertTrue(this.adminPOM.checkEmptyName());
    }

    @When("The Admin submits the form without adding a description")
    public void the_admin_submits_the_form_without_adding_a_description() {
        this.adminPOM.enterProductName("How to get pictures of Uranus");
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the description field")
    public void the_form_produces_an_error_message_on_the_description_field() {
        this.adminPOM.waitHere();
        Assertions.assertTrue(this.adminPOM.checkEmptyDescription());
    }

    @When("The Admin submits the form without adding a regular price")
    public void the_admin_submits_the_form_without_adding_a_regular_price() {
        this.adminPOM.enterProductName("How to get pictures of Uranus");
        this.adminPOM.enterProductDescription("Lets take pictures of Uranus!");
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the price field")
    public void the_form_produces_an_error_message_on_the_price_field() {
        this.adminPOM.waitHere();
        Assertions.assertTrue(this.adminPOM.checkEmptyRegularPrice());
    }

    @When("The Admin submits the form without adding image")
    public void the_admin_submits_the_form_without_adding_image() {
        this.adminPOM.enterProductName("How to get pictures of Uranus");
        this.adminPOM.enterProductDescription("Lets take pictures of Uranus!");
        this.adminPOM.enterProductRegularPrice(1.99);
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("The form produces an stays the same and has place holder image")
    public void the_form_produces_an_stays_the_same_and_has_place_holder_image() {
        this.adminPOM.waitHere();
        Assertions.assertTrue(this.adminPOM.checkEmptyImage());
    }

    @When("A user inputs valid fields into everything but sale price and clicks create product")
    public void a_user_inputs_valid_fields_into_everything_but_sale_price_and_clicks_create_product() {
       this.adminPOM.enterProductName("Selenium Testing Basics");
       this.adminPOM.enterProductDescription("This product was made as a test from selenium");
       this.adminPOM.enterProductRealPrice("100");
       this.adminPOM.enterProductRealStock("50");
       this.adminPOM.clickCreateProductBtn();
    }
    @Then("A new product is created")
    public void a_new_product_is_created() {
        this.adminPOM.waitForSuccessfulRedirect();
        Assertions.assertTrue(this.adminPOM.getCurrentUrl().contains("http://localhost:4200/product/"));

    }

    @When("A user inputs valid fields into everything and clicks create product")
    public void a_user_inputs_valid_fields_into_everything_and_clicks_create_product() {
        this.adminPOM.enterProductName("Selenium Testing Basics 2.0");
        this.adminPOM.enterProductDescription("This product was made as a second test from selenium");
        this.adminPOM.enterProductRealPrice("100");
        this.adminPOM.enterProductRealSalesPrice("50");
        this.adminPOM.enterProductRealStock("50");
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("a new product with a sale is created")
    public void a_new_product_with_a_sale_is_created() {
        this.adminPOM.waitForSuccessfulRedirect();
        Assertions.assertTrue(this.adminPOM.saleRibbonIsVisible());
    }

    @When("User fills out the name, description, price \\(lower then sale price), sales price, stock, and presses submit")
    public void user_fills_out_the_name_description_price_lower_then_sale_price_sales_price_stock_and_presses_submit() {
        this.adminPOM.enterProductName("Selenium Testing Basics 2.0");
        this.adminPOM.enterProductDescription("This product was made as a second test from selenium");
        this.adminPOM.enterProductRealSalesPrice("50");
        this.adminPOM.enterProductRealPrice("10");
        this.adminPOM.enterProductRealStock("50");
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("User is prompted with an error message")
    public void user_is_prompted_with_an_error_message() {
       Assertions.assertEquals("http://localhost:4200/admin-new-product", this.adminPOM.getCurrentUrl());
    }

    @When("User fills out the name, description, price, sales price \\(higher then price), stock, and presses submit")
    public void user_fills_out_the_name_description_price_sales_price_higher_then_price_stock_and_presses_submit() {
        this.adminPOM.enterProductName("Selenium Testing Basics 2.0");
        this.adminPOM.enterProductDescription("This product was made as a second test from selenium");
        this.adminPOM.enterProductRealPrice("10");
        this.adminPOM.enterProductRealSalesPrice("50");
        this.adminPOM.enterProductRealStock("50");
        this.adminPOM.clickCreateProductBtn();
    }
}
