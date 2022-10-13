package Step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;
@Before
    public static void OpenBrowser() throws InterruptedException {
    //Bridge
    String chromepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Browser\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", chromepath);
    //2-New Object WebDriver
    driver = new ChromeDriver();
    //3- Driver Navigate to nopcommerce Website and Mange
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    driver.navigate().to("https://demo.nopcommerce.com/");

}


@After
    public static void CloseBrowser() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}
}
