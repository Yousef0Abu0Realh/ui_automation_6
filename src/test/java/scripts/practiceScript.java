package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practiceScript {
    public static WebDriver driver;
    @BeforeMethod
    public static void setPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }
    @AfterMethod
    public static void tearDown(){

    }
    @Test
    public static void openYTGaming(){

    }


}
