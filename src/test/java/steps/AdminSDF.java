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
        this.adminPOM.enterProductRegularPrice(0.99);
        this.adminPOM.clickCreateProductBtn();
    }
    @Then("The form produces an stays the same and has place holder image")
    public void the_form_produces_an_stays_the_same_and_has_place_holder_image() {
        this.adminPOM.waitHere();
        Assertions.assertTrue(this.adminPOM.checkEmptyImage());
    }
}
