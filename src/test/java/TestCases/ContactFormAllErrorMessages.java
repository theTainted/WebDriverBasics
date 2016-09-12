package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
        List<WebElement> listOfErrorMessage= driver.findElements(By.xpath("//div[@id='feedbackPanel']//li"));
        System.out.println(listOfErrorMessage.size());
        for(WebElement errorMessage:listOfErrorMessage){

            switch (sURL) {
                case "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato":
                    property.load(new FileInputStream("C:\\Users\\Syam\\IdeaProjects\\WebDriverBasics\\PT.txt"));
            }
                    Assert.assertEquals(property.getProperty("Empty_First_Name"), listOfErrorMessage.get(0).getText(), "First Name");
                    Assert.assertEquals(property.getProperty("Empty_Last_Name"), listOfErrorMessage.get(1).getText(), "Last Name");

            }



        }
    }

//we need to work out a simple way, like adding arrays and comparing from it,