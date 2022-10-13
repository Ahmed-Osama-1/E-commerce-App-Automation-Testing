package Step_definition;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D04_searchStepDefinition {
    P03_HomePage searchbar = new P03_HomePage();

    public D04_searchStepDefinition() {
    }

    @When("user clicks in search filed")
    public void user_clicks_search_field() {
        this.searchbar.searchBox();
    }

    @And("^user Type product name as \"(.*)\"$")
    public void user_type_product_name(String productname) {
        this.searchbar.typeProductName(productname);
        this.searchbar.searchBtn().click();
    }

    @Then("user find relevant products")
    public void user_find_relevant_products() {
        this.searchbar.searchResult();
    }

    @When("^user Type product sku as \"(.*)\"$")
    public void user_type_product_sku(String sku) throws InterruptedException {
        this.searchbar.typeProductSku(sku);
        this.searchbar.searchBtn().click();
        Thread.sleep(2000);
    }

    @Then("^\"(.*)\" shown in result page")
    public void sku_shown_in_result_page(String sku) throws InterruptedException {
        this.searchbar.skuResult(sku);
    }

}
