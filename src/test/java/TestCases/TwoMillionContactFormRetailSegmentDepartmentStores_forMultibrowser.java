package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 10-09-2016.
 */
public class TwoMillionContactFormRetailSegmentDepartmentStores_forMultibrowser {
 // private static String sURL = "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato";
        String sURL = ContactForm.sURL;
        WebDriver driver;
  //  public static void main(String[] args) {
  @Parameters("browser")

  @BeforeClass

  // Passing Browser parameter from TestNG xml

  public void beforeTest(String browser) {

      // If the browser is Firefox, then do this

      if (browser.equalsIgnoreCase("firefox")) {
          System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
          driver =new FirefoxDriver();



          // If browser is IE, then do this

      } else if (browser.equalsIgnoreCase("chrome")) {

          // Here I am setting up the path for my IEDriver

          System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

          driver = new ChromeDriver();

      }
      driver.navigate().to(sURL);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
      @Test
      public void testTwoMillionContactFormRetailSegmentDepartmentStores(){
   // System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
       // WebDriver driver = new ChromeDriver();

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
        contactform.countrySelector("Afghanistan");
        contactform.selectSalesVolume("New business - 2 million");
        contactform.setMessageInMessageBox("Test Message");
        contactform.clickSubmit();
        driver.quit();
    }
}
