package TestCases;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 21-08-2016.
 */
public class TestCases {


    public static void main(String [] args){
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
        WebDriver driver= new FirefoxDriver();
        driver.navigate().to("https://www.google.com/ncr");
        HomePage homePage = new HomePage(driver);
       homePage.SearchGoogle("Selenium");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickSelenium();
    }
}
