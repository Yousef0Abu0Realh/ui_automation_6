package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _04_TGLocatorsTest extends Base{
    /*
    Go to "https://techglobal-training.com/frontend/xpath-css-locators"
    Validate the header is "Xpath-CSS Locators"
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/xpath-css-locators");
    }

    @Test
    public void validateTheHeader() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("card-2")).click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.cssSelector("#main_heading"));

        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(), "Xpath-CSS Locators");
    }

    @Test
    public void validateLanguages(){
        List<WebElement> languages = driver.findElements(By.xpath("(//h3[@class='Xpath_subheader__VOtsU'])[1]/../ul/li"));

        String[] expectedTexts = {"Java", "JavaScript", "C#"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(languages.get(i).isDisplayed());
            Assert.assertEquals(languages.get(i).getText(), expectedTexts[i]);
        }
    }

    @Test
    public void validateListHeaders(){
        
    }
}