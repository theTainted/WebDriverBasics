package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static PageObjects.ContactForm.sURL;

/**
 * Created by syam.suryanarayanan on 9/30/2016.
 */
public class AvailabilityOfCurrencyDropDown {
    @Test
    public void testAvailabilityOfCurrencyDropDown(){
    //sURL="https://www-ingenico-test-global.lostboys.nl/de/epayments/kontaktiere-uns";

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(sURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ContactForm contactform = new ContactForm(driver);
        contactform.switchToFrame(0);
        contactform.isCurrencyDropDownAvailable();

          //driver.quit();

    }
}

