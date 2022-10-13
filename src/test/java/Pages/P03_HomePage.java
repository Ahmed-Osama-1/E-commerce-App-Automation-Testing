package Pages;

import Step_definition.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class P03_HomePage {
    int rondomNumber;



    public P03_HomePage() {
    }

    public void selectEuro() throws InterruptedException {
        WebElement euro = Hooks.driver.findElement(By.name("customerCurrency"));
        Select select = new Select(euro);
        Thread.sleep(2000);
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    public void euroSymbol() {
        int count = Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).size();

        for (int x = 0; x < count; ++x) {
            String text = ((WebElement) Hooks.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).get(x)).getText();
            Assert.assertTrue(text.contains("€"));
        }
    }

    public WebElement searchBox() {
        By searchBox = By.id("small-searchterms");
        WebElement searchBoxEle = Hooks.driver.findElement(searchBox);
        return searchBoxEle;
    }

    public WebElement searchBtn() {
        By searchBtn = By.className("button-1");
        WebElement searchBtnEle = Hooks.driver.findElement(searchBtn);
        String searchUrl = Hooks.driver.getCurrentUrl();
        System.out.println(searchUrl);
        String expectedUrl = "https://demo.nopcommerce.com/search?";
        Assert.assertTrue(expectedUrl.contains(searchUrl));
        return searchBtnEle;
    }

    public void typeProductName(String productname) {
        int pcount = Hooks.driver.findElements(By.id("small-searchterms")).size();

        for (int x = 0; x < pcount; ++x) {
            ((WebElement) Hooks.driver.findElements(By.id("small-searchterms")).get(x)).sendKeys(productname);
        }

    }

    public void searchResult() {
        int item = Hooks.driver.findElements(By.id("small-searchterms")).size();

        for (int x = 0; x < item; ++x) {
            String itemname = ((WebElement) Hooks.driver.findElements(By.className("product-item")).get(x)).getText();
            String searchinput = ((WebElement) Hooks.driver.findElements(By.id("small-searchterms")).get(x)).getText();
            Assert.assertTrue(itemname.contains(searchinput));
        }

    }

    public void typeProductSku(String sku) throws InterruptedException {
        int scount = Hooks.driver.findElements(By.id("small-searchterms")).size();

        for (int x = 0; x < scount; ++x) {
            ((WebElement) Hooks.driver.findElements(By.id("small-searchterms")).get(x)).sendKeys(sku);
            Thread.sleep(2000);
        }

    }

    public void skuResult(String sku) throws InterruptedException {
        Hooks.driver.findElement(By.className("picture")).click();
        Thread.sleep(3000);
        String actualsku = Hooks.driver.findElement(By.className("sku")).getText();
        System.out.println("actual  " + actualsku);
        System.out.println("expected  " + sku);
        String tag = "SKU: ";
        Assert.assertEquals(tag.concat(sku), actualsku);
    }

    public WebElement computerHover(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    }
    public WebElement electronicsHover(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
    }
    public WebElement aparelHover(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
    }
    public By desktopSub(){
        return By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a");
    }
    public By pageTitle(){
        return By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1");
    }





    public WebElement locateFirstSlider() throws InterruptedException {
        By firstSlider = By.xpath("//a[@rel=\"0\"]");
        WebElement firstSliderEle = Hooks.driver.findElement(firstSlider);
        Thread.sleep(1000);
        System.out.println(firstSliderEle.getText());
        return firstSliderEle;
    }

    public WebElement selectFirstProduct() throws InterruptedException {
        By firstSliderProduct = By.xpath("//*[@id=\"nivo-slider\"]/a[1]");
        WebElement firstSliderProductEle = Hooks.driver.findElement(firstSliderProduct);
        Thread.sleep(1000);
        return firstSliderProductEle;
    }

    public void getFirstSliderProductUrl() {
        String firstSliderProductUrl = Hooks.driver.getCurrentUrl();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(firstSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(firstSliderProductUrl, expectedUrl);
    }

    public WebElement locateSecondSlider() throws InterruptedException {
        By secondSlider = By.xpath("//a[@rel=\"1\"]");
        WebElement secondSliderEle = Hooks.driver.findElement(secondSlider);
        Thread.sleep(1000);
        System.out.println(secondSliderEle.getText());
        return secondSliderEle;
    }

    public WebElement selectSecondProduct() throws InterruptedException {
        By SecondSliderProduct = By.xpath("//*[@id=\"nivo-slider\"]/a[2]");
        WebElement secondSliderProductEle = Hooks.driver.findElement(SecondSliderProduct);
        Thread.sleep(1000);
        return secondSliderProductEle;
    }

    public void getSecondSliderProductUrl() {
        String SecondSliderProductUrl = Hooks.driver.getCurrentUrl();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(SecondSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(SecondSliderProductUrl, expectedUrl);
    }

    public WebElement clickfacebookLink() {
        WebElement faceBookEle = Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
        String faceBookLink = faceBookEle.getText();
        System.out.println(faceBookLink);
        return faceBookEle;
    }

    public WebElement clickTwitterLink() {
        WebElement twitterEle = Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
        String twitterLink = twitterEle.getText();
        System.out.println(twitterLink);
        return twitterEle;
    }

    public WebElement clickRssLink() {
        WebElement rssEle = Hooks.driver.findElement(By.className("rss"));
        String rssLink = rssEle.getText();
        System.out.println(rssLink);
        return rssEle;
    }

    public WebElement clickUtubeLink() {
        WebElement uTubeEle = Hooks.driver.findElement(By.className("youtube"));
        String uTubeLink = uTubeEle.getText();
        System.out.println(uTubeLink);
        return uTubeEle;
    }
    public static int covarteStringToInt(String text){

       String value= text.replaceAll("[^0-9]","");
        return Integer.parseInt(text);
    }

    public void wishlist_item() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();
        System.out.println(text);

        text = text.replaceAll("[^0-9]", "");
        int number = Integer.parseInt(text);
        Assert.assertTrue(number > 0);
    }

    public List<WebElement> wishlistbtn() {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }





}
