package Step_definition;

import Pages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class D02_LoginStepDefinition {
    P02_Login login = new P02_Login();

    @Given("user go to login page")
    public void user_go_to_login_page()
    {
        login.loginBtn().click();
    }


    @When("^user login with valid\" \"(.*)\" and \"(.*)\"$")
    public void validLogin(String validEmail, String validPassword)
    {

        login.validEmail().sendKeys(validEmail);
        login.validPassword().sendKeys(validPassword);
    }
    @And("user press on login button")
    public void logBtn() throws InterruptedException {

        login.logBtn().click();
    }
    @Then("user login to the system successfully")

    public void successLogin()
    {
        login.successLogin();
    }

    @And("^user login with invalid\" \"(.*)\" and \"(.*)\"$")
    public void invalidLogin(String invalidEmail, String invalidPassword)
    {
        login.invalidEmail().sendKeys("invalid"+invalidEmail);
        login.invalidPassword().sendKeys("invalid"+invalidPassword);
    }

    @Then("user could not login to the system")
    public void unSuccessLogin()
    {
        login.unSuccessLogin();
    }
}






