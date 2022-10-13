package Step_definition;

import Pages.P03_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class D03_CurrenciesStepDefinition {
    P03_HomePage currency = new P03_HomePage();

    public D03_CurrenciesStepDefinition() {
    }

    @Given("user select euro currency")
    public void user_select_euro() throws InterruptedException {
        this.currency.selectEuro();
    }

    @Then("user can find euro symbol displayed in home page products")
    public void euro_symbol() {
        this.currency.euroSymbol();
    }
}
