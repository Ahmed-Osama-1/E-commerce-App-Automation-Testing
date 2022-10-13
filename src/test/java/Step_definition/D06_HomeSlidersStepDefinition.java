package Step_definition;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D06_HomeSlidersStepDefinition {
    P03_HomePage slider = new P03_HomePage();

    public D06_HomeSlidersStepDefinition() {
    }

    @When("user clicks on first slider")
    public void user_clicks_first_slider() throws InterruptedException {
        this.slider.locateFirstSlider().click();
    }

    @And("user select product of first slider")
    public void user_select_first_product() throws InterruptedException {
        this.slider.selectFirstProduct().click();
    }

    @Then("user go to first product page")
    public void user_go_first_product_page() {
        this.slider.getFirstSliderProductUrl();
    }

    @When("user clicks on second slider")
    public void user_clicks_second_slider() throws InterruptedException {
        this.slider.locateSecondSlider().click();
    }

    @And("user select product of Second slider")
    public void user_select_second_product() throws InterruptedException {
        this.slider.selectSecondProduct().click();
    }

    @Then("user go to second product page")
    public void user_go_second_product_page() {
        this.slider.getSecondSliderProductUrl();
    }
}


