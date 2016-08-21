package TestCases;

import HomePage.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Syam on 21-08-2016.
 */
public class TestCases {


    public static void main(String [] args){
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
        WebDriver driver= new FirefoxDriver();
        driver.navigate().to("https://www.google.com/ncr");
    homePage homePage = new homePage(driver);
        homePage.txtSearch.sendKeys("Selenium");
        homePage.btnSearch.click();
    }
}
