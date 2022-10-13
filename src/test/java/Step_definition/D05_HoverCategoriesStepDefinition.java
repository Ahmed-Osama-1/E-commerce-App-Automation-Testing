package Step_definition;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class D05_HoverCategoriesStepDefinition {
    P03_HomePage category = new P03_HomePage();

    @Given("user hover categories")
    public void hover(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(category.aparelHover()).perform();
        action.moveToElement(category.electronicsHover()).perform();
        action.moveToElement(category.computerHover()).perform();


    }
    @When("user click on subcategory")
    public void click_subcategory(){
        Hooks.driver.findElement(category.desktopSub()).click();
    }
    @And("user go to product page")
    public void product_page(){
        String expected="Desktops";
        String actual=Hooks.driver.findElement(category.pageTitle()).getText();
        Assert.assertTrue(actual.contains(expected));
    }
}
