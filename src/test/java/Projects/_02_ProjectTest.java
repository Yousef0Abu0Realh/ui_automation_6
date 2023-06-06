package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;

public class _02_ProjectTest extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-22")).click();
    }
    @Test(priority = 1)
    public void validateTheLoginForm(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement userLabel = driver.findElement(By.cssSelector("div [for='username']"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("div  [for='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));

        Assert.assertTrue(userInput.isDisplayed());
        Assert.assertNull(userInput.getAttribute("required"));

        Assert.assertEquals(userLabel.getText(),"Please enter your username");

        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertNull(passwordInput.getAttribute("required"));

        Assert.assertEquals(passwordLabel.getText(),"Please enter your password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(),"LOGIN");

        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(),"Forgot Password?");
    }
    @Test (priority = 2)
    public void validateTheValidLogin(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement successfulLogin = driver.findElement(By.id("success_lgn"));
        Assert.assertEquals(successfulLogin.getText(),"You are logged in");

        WebElement logOut = driver.findElement(By.id("logout"));
        Assert.assertTrue(logOut.isDisplayed());
        Assert.assertEquals(logOut.getText(),"LOGOUT");

    }
    @Test(priority = 3)
    public void validateTheLogout(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement logOut = driver.findElement(By.id("logout"));
        logOut.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        loginForm.isDisplayed();
    }
    @Test(priority = 4)
    public void validateTheForgotPassword(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement modelHeading = driver.findElement(By.id("modal_title"));
        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='close']"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(modelHeading.isDisplayed());
        Assert.assertTrue(closeButton.isDisplayed());
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertEquals(emailLabel.getText(),"Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(),"SUBMIT");
    }
    @Test(priority = 5)
    public void validateTheResetModalCloseButton(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement modalDisplayed = driver.findElement(By.cssSelector(".modal-card-body"));
        Assert.assertTrue(modalDisplayed.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='close']"));
        closeButton.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        loginForm.isDisplayed();
    }
    @Test (priority = 6)
    public void validateTheResetPasswordFormSubmission(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("yahya.w.akif@gmail.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement validateMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(validateMessage.getText(),"A link to reset your password has been sent to your email address.");
    }
    @Test (priority = 7)
    public void validateTheInvalidLoginWithEmptyCredentials(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }
    @Test (priority = 8)
    public void validateTheInvalidLoginWithWrongUserName(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("John");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }
    @Test(priority = 9)
    public void validateTheInvalidLoginWithWrongPassword(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Password entered!");
    }
    @Test(priority = 10)
    public void validateTheInvalidLoginWithWrongUserNameAndPassword(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("John");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }

}
