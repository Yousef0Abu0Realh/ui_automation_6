package scripts;

import Pages.Project2Page;
import Pages.project3Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Driver;

import javax.swing.*;

public class Base {
    public static WebDriver driver; // declaration
    public static Actions actions;

    //Declaring pages
    public static Project2Page project2Page;
    public static project3Page project3Page;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
