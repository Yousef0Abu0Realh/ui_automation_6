package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _01_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test(priority = 1)
    public void validateContactUs(){
        WebElement header = driver.findElement(By.cssSelector(".is-size-2"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(),"Contact Us");

        List<WebElement> headers = driver.findElements(By.cssSelector("div[class='mb-5'] p"));
        String[] expectText ={"2860 S River Rd Suite 350, Des Plaines IL 60018", "info@techglobalschool.com","(773) 257-3010"};
        for (int i = 0; i < headers.size(); i++) {
            Assert.assertTrue(headers.get(i).isDisplayed());
            Assert.assertEquals(headers.get(i).getText(), expectText[i]);
        }
    }

    @Test(priority = 2)
    public void validateTheFullNameInput(){
        WebElement inputFullName = driver.findElement(By.cssSelector("input[placeholder*='your full name']"));
        WebElement fullName = driver.findElement(By.cssSelector("label[for='name']"));
        Assert.assertTrue(fullName.isDisplayed());
        Assert.assertEquals(fullName.getText(),"Full name *");
        Assert.assertTrue(true,inputFullName.getAttribute("required"));
        Assert.assertEquals(inputFullName.getAttribute("placeholder"), "Enter your full name");
    }


    @Test(priority = 3)
    public void ValidateTheGenderRadioButton(){
        WebElement gender = driver.findElement(By.cssSelector("div.field:nth-child(2) label.label"));
        Assert.assertEquals(gender.getText(), "Gender *");
        Assert.assertTrue(true,gender.getAttribute("required"));

        List<WebElement> genderTypes = driver.findElements(By.cssSelector("div[class='field'] label.radio"));
        List<WebElement> genderInput = driver.findElements(By.cssSelector(".mr-1"));
        String[] expectedText = {"Male","Female", "Prefer not to disclose"};
        for (int i = 0; i < genderTypes.size(); i++) {
            Assert.assertEquals(genderTypes.get(i).getText(),expectedText[i]);
            Assert.assertTrue(genderTypes.get(i).isDisplayed());
            Assert.assertTrue(genderInput.get(i).isEnabled());
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        for (int i = 0; i < genderInput.size(); i++) {
            if(i == 0) continue;
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        for (int i = 0; i < genderInput.size(); i++) {
            if(i == 1) continue;
            Assert.assertFalse(genderInput.get(i).isSelected());
        }
    }



    @Test (priority = 4)
    public void validateTheAddressInputBox(){
        WebElement addressInput= driver.findElement(By.cssSelector("div[class='field']:nth-child(3) input"));
        WebElement addressLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) label"));
        Assert.assertTrue(addressInput.isDisplayed());
        Assert.assertFalse(false, addressInput.getAttribute("required"));
        Assert.assertEquals(addressLabel.getText(),"Address");
        Assert.assertEquals(addressInput.getAttribute("placeholder"), "Enter your address");
    }



    @Test (priority =5)
    public void validateTheEmailInputBox(){
        WebElement emailInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        WebElement emailLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) label"));

        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(true,emailInput.getAttribute("required"));
        Assert.assertEquals(emailLabel.getText(), "Email *");
        Assert.assertEquals(emailInput.getAttribute("placeholder"),"Enter your email");
    }

    @Test (priority = 6)
    public void validateThePhoneInputBox(){
        WebElement phoneInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        WebElement phoneLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) label"));

        Assert.assertTrue(phoneInput.isDisplayed());
        Assert.assertFalse(false,phoneInput.getAttribute("required"));
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"),"Enter your phone number");

    }

    @Test (priority = 7)
    public void validateTheMessageTextArea(){
        WebElement messageInput = driver.findElement(By.cssSelector(".textarea"));
        WebElement messageLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(6) label"));

        Assert.assertTrue(messageLabel.isDisplayed());
        Assert.assertTrue(true,messageInput.getAttribute("required"));
        Assert.assertEquals(messageLabel.getText(),"Message");
        Assert.assertEquals(messageInput.getAttribute("placeholder"),"Type your message here...");
    }


    @Test (priority = 8)
    public void validateTheConsentCheckBox(){
        WebElement consentLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) label"));
        WebElement consentInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) input"));

        Assert.assertEquals(consentLabel.getText(),"I give my consent to be contacted.");
        Assert.assertTrue(true,consentInput.getAttribute("required"));
        Assert.assertTrue(consentInput.isEnabled());
        consentInput.click();
        Assert.assertTrue(consentInput.isSelected());
        consentInput.click();
        Assert.assertFalse(consentInput.isSelected());
    }



    @Test (priority = 9)
    public void validateTheSubmitButton(){
        WebElement submitLabel = driver.findElement(By.cssSelector(".is-link"));

        Assert.assertTrue(submitLabel.isDisplayed());
        Assert.assertTrue(submitLabel.isEnabled());
        Assert.assertEquals(submitLabel.getText(),"SUBMIT");
    }

    @Test (priority = 10)
    public void validateTheFormSubmission(){
        WebElement inputFullName = driver.findElement(By.cssSelector("input[placeholder*='your full name']"));
        List<WebElement> genderInput = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInput= driver.findElement(By.cssSelector("div[class='field']:nth-child(3) input"));
        WebElement emailInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        WebElement phoneInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        WebElement messageInput = driver.findElement(By.cssSelector(".textarea"));
        WebElement consentInput = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) input"));
        WebElement submitLabel = driver.findElement(By.cssSelector(".is-link"));

        inputFullName.sendKeys("Yhehia Akif");
        genderInput.get(0).click();
        addressInput.sendKeys("683 N Katherine Ln");
        emailInput.sendKeys("yahya_waad@yahoo.com");
        phoneInput.sendKeys("630-804-9664");
        messageInput.sendKeys("Hii guys");
        consentInput.click();
        submitLabel.submit();
        WebElement finalMessage = driver.findElement(By.cssSelector(".mt-5"));

        Assert.assertTrue(finalMessage.isDisplayed());
        Assert.assertEquals(finalMessage.getText(),"Thanks for submitting!");
    }
}

