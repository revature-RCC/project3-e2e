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
}
