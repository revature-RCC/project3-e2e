package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.EditPOM;

public class EditSDF {

    EditPOM editPOM;

    @Given("The admin is on the edit product page")
    public void the_admin_is_on_the_edit_product_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/admin-new-product");

        this.editPOM = new EditPOM(DriverSingleton.getInstance());

        Assertions.assertEquals("http://localhost:4200/admin-new-product", this.editPOM.getCurrentUrl());
    }

    @When("The admin changes the name of the product")
    public void the_admin_changes_the_name_of_the_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The admin changes the description of the product")
    public void the_admin_changes_the_description_of_the_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The admin changes the price of the product")
    public void the_admin_changes_the_price_of_the_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The admin changes the sale price of the product")
    public void the_admin_changes_the_sale_price_of_the_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The admin changes the stock amount of the product")
    public void the_admin_changes_the_stock_amount_of_the_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The user tries to change the price lower than the sale price")
    public void the_user_tries_to_change_the_price_lower_than_the_sale_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("The user tries to change the sale price higher than the original price")
    public void the_user_tries_to_change_the_sale_price_higher_than_the_original_price() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The admin is redirected to the product page")
    public void the_admin_is_redirected_to_the_product_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The user will stay on the edit product page")
    public void the_user_will_stay_on_the_edit_product_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
