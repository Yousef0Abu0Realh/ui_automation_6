package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.security.Key;
import java.time.Duration;

public class _19_TGActionsTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }


    @Test
    public void mouseActions(){
        WebElement clickOnMeButton = driver.findElement(By.id("click"));
        WebElement rightClickButton = driver.findElement(By.id("right-click"));
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));

        actions.moveToElement(clickOnMeButton).click().perform();
        actions.moveToElement(rightClickButton).contextClick().perform();
        actions.moveToElement(doubleClickButton).doubleClick().perform();

        WebElement clickResult = driver.findElement(By.id("click_result"));
        WebElement rightClickResult = driver.findElement(By.id("right_click_result"));
        WebElement doubleClickResult = driver.findElement(By.id("double_click_result"));


        Assert.assertEquals(clickResult.getText(), "You clicked on a button!");
        Assert.assertEquals(rightClickResult.getText(), "You right-clicked on a button!");
        Assert.assertEquals(doubleClickResult.getText(), "You double-clicked on a button!");

        Waiter.pause(3);
    }
    @Test
    public void dragAndDrop(){
        WebElement dragElementButton = driver.findElement(By.id("drag_element"));
        WebElement dropElementButton = driver.findElement(By.id("drop_element"));

//        actions.dragAndDrop(dragElementButton, dropElementButton).perform();

        actions.moveToElement(dragElementButton).clickAndHold().moveToElement(dropElementButton).release().perform();

        WebElement dragAndDropResult = driver.findElement(By.id("drag_and_drop_result"));

        Waiter.waitForVisibilityOfElement(dragAndDropResult, 30);

        Assert.assertEquals(dragAndDropResult.getText(), "An element dropped here!");

        Waiter.pause(3);

    }
    @Test
    public void keyboardActions(){

        WebElement inputBox = driver.findElement(By.id("input_box"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys("ello")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(inputBox.getAttribute("value"), "Hello");
    }

}
