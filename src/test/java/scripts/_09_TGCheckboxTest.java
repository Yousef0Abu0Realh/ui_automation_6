package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckboxTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void checkboxTest(){
        List<WebElement> checkboxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkboxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        checkboxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertTrue(checkboxInput.get(i).isSelected());
        }
    }

}
