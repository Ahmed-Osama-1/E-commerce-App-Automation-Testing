package Pages;

import Step_definition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class P01_Register {

    public WebElement RegisterLink(){
        WebElement reg= Hooks.driver.findElement(By.className("ico-register"));
        return reg;
    }
    public void gender() throws InterruptedException {
        Hooks.driver.findElement(By.id("gender-female")).click();
        Thread.sleep(2000L);
        Hooks.driver.findElement(By.id("gender-male")).click();
    }
    public WebElement first_name() {
        By firstName = By.id("FirstName");
        WebElement firstNameEle = Hooks.driver.findElement(firstName);
        return firstNameEle;
    }

    public WebElement last_name() {
        By lastName = By.id("LastName");
        WebElement lastNameEle = Hooks.driver.findElement(lastName);
        return lastNameEle;
    }

    public void date_of_birth() throws InterruptedException {
        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        Thread.sleep(2000L);
        select.selectByIndex(1);
        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(birthMonth);
        Thread.sleep(2000L);
        select.selectByValue("1");
        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(birthYear);
        Thread.sleep(2000L);
        select.selectByVisibleText("1998");
    }

    public WebElement email() {
        By email = By.id("Email");
        WebElement emailEle = Hooks.driver.findElement(email);
        return emailEle;
    }

    public WebElement fillPassword() {
        By password = By.id("Password");
        WebElement passwordEle = Hooks.driver.findElement(password);
        return passwordEle;
    }

    public WebElement confirmPassword() {
        By confPassword = By.id("ConfirmPassword");
        WebElement confirmpasswordEle = Hooks.driver.findElement(confPassword);
        return confirmpasswordEle;
    }
    public WebElement registBtn() throws InterruptedException {
        WebElement registBtn = Hooks.driver.findElement(By.id("register-button"));
        Thread.sleep(3000L);
        return registBtn;
    }

    public void result() {
        String actualResult = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        System.out.println(actualResult);
        String expectedResult = "Your registration completed";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualResult, expectedResult);
        String expectedColor = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        String actualColor = Color.fromString(expectedColor).asHex();
        soft.assertEquals(actualColor, "#4cb17c");
        soft.assertAll();
    }



}
