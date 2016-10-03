package TestCases;

import PageObjects.ContactForm;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 9/12/2016.
 */
public class ContactFormAllErrorMessages {
    static Properties property = new Properties();
    static String sURL = "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato";

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(sURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ContactForm contactform = new ContactForm(driver);
        contactform.switchToFrame(0);
        contactform.clickSubmit();
        contactform.switchToDefaultFrame();
        List<WebElement> listOfErrorMessage= driver.findElements(By.xpath("//div[@id='feedbackPanel']//li"));

      //  System.out.println(listOfErrorMessage.size());
     //   for(WebElement errorMessage:listOfErrorMessage){

            switch (sURL) {
                case "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato":
                    property.load(new FileInputStream("..\\WebDriverBasics\\PT.txt"));
                    Assert.assertEquals(property.getProperty("Empty_First_Name"), listOfErrorMessage.get(0).getText(), "the expected and actual dont match");
                    Assert.assertEquals(property.getProperty("Empty_Last_Name"), listOfErrorMessage.get(1).getText(), "the expected and actual dont match");
                    Assert.assertEquals(property.getProperty("Empty_JobTitle"), listOfErrorMessage.get(2).getText(), "the expected and actual dont match");
                    Assert.assertEquals(property.getProperty("Empty_Email"), listOfErrorMessage.get(3).getText(), "the expected and actual dont match");
                    Assert.assertEquals(property.getProperty("Empty_Empty_Telephone"),listOfErrorMessage.get(4).getText(),"the expected and actual dont match");

                default:
                    System.out.println("nothing to match");
            }


            }



        }
 //   }

