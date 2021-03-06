package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 10-09-2016.
 */
public class TwotoFiveMillionContactFormSegmentMerchantServiceProvidersValueAddedResellers {
    String sURL = ContactForm.sURL;

  //  public static void main(String[] args) {

    @Test
       public void testwotoFiveMillionContactFormSegmentMerchantServiceProvidersValueAddedResellers(){
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
        contactform.selectIndustry("Merchants Services Providers");
        contactform.selectSegmentForMerchantsServicesProviders("Value Added Resellers");
        contactform.countrySelector("Panama");
        contactform.selectSalesVolume("2 - 5 million");
        contactform.selectTargetMarket("Asia/Pacific");
        contactform.selectTargetMarket("Middle East");
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}
