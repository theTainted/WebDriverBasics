package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 9/16/2016.
 */
public class TwoToFiveMillionContactFormFinancialServiceSegmentPaymentServiceProviders {
    String sURL = ContactForm.sURL;

    //  public static void main(String[] args) {
    @Test
    public void testTwoToFiveMillionContactFormFinancialServiceSegmentPaymentServiceProviders() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sValue = "Europe";
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

        contactform.selectIndustry(1);
        contactform.selectSegementForFinancialIndustry(1);
        contactform.countrySelector(22);
        contactform.selectSalesVolume(2);
        contactform.selectTargetMarket("Latin America");
        contactform.selectTargetMarket("Europe");
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}