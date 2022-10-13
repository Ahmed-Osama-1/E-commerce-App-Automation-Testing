package Step_definition;

import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D08_WishlistStepDefinition {
    P03_HomePage wishlist = new P03_HomePage();
    String text=null;
    int number;

    @When("user add product to wishlist")
    public void user_add_product_to_wishlist() throws InterruptedException {
        Thread.sleep(4000);
        wishlist.wishlistbtn().get(2).click();
    }

    @Then("wishlist notification success is visible")
    public void notificationSucces() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).isDisplayed());
    }

    @And("user get the number of wishlist items after adding product")
    public void wishlist_item() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text=Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();
        System.out.println(text);

        text= text.replaceAll("[^0-9]","");
        int number=Integer.parseInt(text);
        Assert.assertTrue(number>0);

    }
    @Then("number of  wishlist item increased")
    public void item_Increased (){
        String text=Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        text= text.replaceAll("[^0-9]","");
        int number=Integer.parseInt(text);
        Assert.assertTrue(number>0);
    }

}
