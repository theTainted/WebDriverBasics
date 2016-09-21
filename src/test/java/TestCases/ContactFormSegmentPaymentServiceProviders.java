package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 9/12/2016.
 */
public class ContactFormSegmentPaymentServiceProviders {
    String sURL = ContactForm.sURL;
@Test
    public void testContactFormSegmentPaymentServiceProviders() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(sURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ContactForm contactform = new ContactForm(driver);
        contactform.switchToFrame(0);
        contactform.setFirstName("Syam");
        contactform.setLastName("s");
        contactform.setJobTitle("tester");
        contactform.setCompany("LBi");
        contactform.setEmail("syam@LBi.com");
        contactform.setPhone("1234567");
        contactform.selectIndustry("Merchants Financial Services Providers");
        contactform.selectSegementForFinancialIndustry(2);
        contactform.countrySelector(2);
        contactform.selectSalesVolume(1);
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}

