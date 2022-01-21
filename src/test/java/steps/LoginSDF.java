package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;

public class LoginSDF {

    LoginPOM loginPOM;



    @Given("a user is on the login page")
    public void a_user_is_on_the_login_page()  {
        DriverSingleton.getInstance().get("http://localhost:4200/login");

        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/login", this.loginPOM.getCurrentUrl());
    }
    @When("a user inputs valid credentials")
    public void a_user_inputs_valid_credentials() {
        this.loginPOM.enterUsername("TestUser");
        this.loginPOM.enterPassword("password");
        this.loginPOM.submitLogin();
    }
    @Then("a user is redirected to the inventory page")
    public void a_user_is_redirected_to_the_inventory_page() {
        this.loginPOM.waitForSuccessfulLogin();
        Assertions.assertEquals("http://localhost:4200/", this.loginPOM.getCurrentUrl());
    }
    @When("a user inputs invalid credentials")
    public void a_user_inputs_invalid_credentials() {
        this.loginPOM.enterUsername("literallyanything");
        this.loginPOM.enterPassword("111111");
        this.loginPOM.submitLogin();
    }
    @Then("an error message appears telling the user that their credentials are incorrect")
    public void an_error_message_appears_telling_the_user_that_their_credentials_are_incorrect() {
        Assertions.assertTrue(this.loginPOM.isErrMessageVisible());
    }
    @When("a user clicks on the register link")
    public void a_user_clicks_on_the_register_link() {
        this.loginPOM.clickRegisterBtn();
    }
    @Then("a user is redirected to the register page")
    public void a_user_is_redirected_to_the_register_page() {
        this.loginPOM.waitForSuccessfulRedirect();
        Assertions.assertEquals("http://localhost:4200/register", this.loginPOM.getCurrentUrl());
    }
}
