package TestCases;

import PageObjects.ContactForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 9/12/2016.
 */
public class ContactFormAllErrorMessages {
    static String sURL = "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(sURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ContactForm contactform = new ContactForm(driver);
        contactform.switchToFrame(0);
       contactform.txtBoxFirstName.click();
        contactform.clickSubmit();
        List<WebElement> listOfErrorMessage= driver.findElements(By.xpath("//div[@id='feedbackPanel']//li"));
        System.out.println(listOfErrorMessage.size());
        for(WebElement errorMessage:listOfErrorMessage){
            System.out.println(errorMessage.getText());
        }
    }
}
