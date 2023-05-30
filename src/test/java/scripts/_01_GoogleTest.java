package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {

    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().setup();// Set up Chrome driver

        driver = new ChromeDriver();// Launch a chrome driver

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();

    }

    @Test(priority = 1)
    public void validateSearchBar() throws InterruptedException {


        WebElement searchInputBox = driver.findElement(By.id("APjFqb"));

        Assert.assertTrue(searchInputBox.isDisplayed());

    }

    @Test(priority = 2)
    public void vaildateTitleAndURL() throws InterruptedException {

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(),"Google");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");


    }
    @Test

    public void validateNavigation() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");

        Thread.sleep(2000);
       driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),("Amazon.com. Spend less. Smile more."));

    }
    @Test
    public void validateSearchButton(){
        WebElement searchButton = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));

        Assert.assertTrue(searchButton.isDisplayed());
        System.out.println(searchButton.getAttribute("value")); // Google Search

        Assert.assertEquals(searchButton.getAttribute("value"), "Google Search");

        Assert.assertTrue(searchButton.isEnabled());
    }
}
