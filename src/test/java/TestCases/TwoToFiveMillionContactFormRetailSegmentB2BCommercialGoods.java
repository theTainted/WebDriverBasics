package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 10-09-2016.
 */
public class TwoToFiveMillionContactFormRetailSegmentB2BCommercialGoods {
    String sURL = ContactForm.sURL;

  //  public static void main(String[] args) {
    @Test
       public void testTwoToFiveMillionContactFormRetailSegmentB2BCommercialGoods(){
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
        contactform.selectIndustry(3);
        contactform.selectSegmentForRetail(1);
        contactform.countrySelector(12);
        contactform.selectSalesVolume(2);
        contactform.selectTargetMarket("Asia/Pacific");
        contactform.selectTargetMarket("Europe");
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}
