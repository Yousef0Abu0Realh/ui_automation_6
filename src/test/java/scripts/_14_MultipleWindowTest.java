package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _14_MultipleWindowTest extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-10")).click();
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Apple"
    Validate the Apple logo is displayed
     */

    @Test
    public void validateTheAppleNavigation(){
        String mainWindow = driver.getWindowHandle(); // TG id

        WebElement appleLink = driver.findElement(By.id("apple"));

        appleLink.click();

        String secondWindow = "";

        for(String s : driver.getWindowHandles()){
            if(!s.equals(mainWindow)) secondWindow = s;
        }

        driver.switchTo().window(secondWindow); // Apple ID

        WebElement appleLogo = driver.findElement(By.cssSelector(".globalnav-link-apple"));

        Assert.assertTrue(appleLogo.isDisplayed());
    }


    @Test
    public void validateTheMicrosoftNavigation(){

    }
}
