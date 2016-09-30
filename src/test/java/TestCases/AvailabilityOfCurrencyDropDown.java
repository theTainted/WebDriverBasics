package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 9/30/2016.
 */
public class AvailabilityOfCurrencyDropDown {
    @Test
    public void testAvailabilityOfCurrencyDropDown(){

      for (int i=0; i<= 1;i++){
          String [] aURL = {"https://www-ingenico-test-global.lostboys.nl/de/epayments/kontaktiere-uns","https://www-ingenico-test-global.lostboys.nl/lar-es/epayments/contacto"};


        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(aURL[i]);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ContactForm contactform = new ContactForm(driver);
        contactform.switchToFrame(0);

        contactform.clickSubmit();
          driver.quit();

    }
}
}
