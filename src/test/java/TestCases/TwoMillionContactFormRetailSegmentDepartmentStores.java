package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 10-09-2016.
 */
public class TwoMillionContactFormRetailSegmentDepartmentStores {
 // private static String sURL = "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato";
        String sURL = ContactForm.sURL;
        WebDriver driver;

    @Test
    public void testTwoMillionContactFormRetailSegmentDepartmentStores() throws InterruptedException {


  /*   System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
      //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("marionette", true);
      WebDriver driver = new FirefoxDriver();*/





System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();




      driver.navigate().to(sURL);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        ContactForm contactform = new ContactForm(driver);
       // driver.navigate().to(sURL);
        contactform.switchToFrame(0);
        contactform.setFirstName("Syam");
        contactform.setLastName("s");
        contactform.setJobTitle("tester");
        contactform.setCompany("LBi");
        contactform.setEmail("syam@LBi.com");
        contactform.setPhone("1234567");



        contactform.selectIndustry("Retail");

        contactform.selectSegmentForRetail("Department stores");
        contactform.countrySelector("Australia");
        contactform.selectSalesVolume("New business - 2 million");
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}
