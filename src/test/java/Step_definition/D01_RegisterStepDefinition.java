package Step_definition;
import Pages.P01_Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class D01_RegisterStepDefinition {
        WebDriver driver=null;
        D01_RegisterStepDefinition login;

    public D01_RegisterStepDefinition() {
    }
        P01_Register register =new P01_Register();
    @Given("user go to register page")
        public void User_Open_Website(){
        register.RegisterLink().click();

    }

    @When("user select gender type")
        public void gender ()throws InterruptedException{

        this.register.gender();

    }

    @And("^user enter firstname \"(.*)\" and lastname \"(.*)\"$")
        public void User_Enter_Name (String firstname ,String lastname){
        this.register.first_name().sendKeys(firstname);
        this.register.last_name().sendKeys(lastname);

    }

    @And("user enter date of birth")
        public void User_Enter_Birth() throws InterruptedException {

        this.register.date_of_birth();
    }


    @And("^user enter email field \"(.*)\"$")
        public void user_enter_email(String email) {
        this.register.email().sendKeys(email);
    }




    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
        public void fills_password_fields(String password, String confPassword) {
        this.register.fillPassword().sendKeys(password);
        this.register.confirmPassword().sendKeys(confPassword);

    }

    @And("user clicks on register button")
        public void user_clicks_on_register_button() throws InterruptedException {
        this.register.registBtn().click();
    }

    @Then("success message is displayed")
        public void Success_message_displayed() {
        this.register.result();
    }




}
