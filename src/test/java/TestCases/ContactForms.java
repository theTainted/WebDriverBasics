package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

/**
 * Created by syam.suryanarayanan on 9/2/2016.
 */
public class ContactForms {

    public static void main(String[] args) throws InterruptedException, IOException {

        //  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sUrl = "https://www-ingenico-test-global.lostboys.nl/apac/epayments/contact-us";
        driver.navigate().to(sUrl);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Boolean bValue = driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).isDisplayed();
        if (bValue) {
            driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).click();

        }
        driver.switchTo().frame(0);
        Boolean lastNameVisible= driver.findElement(By.name("lastname")).isDisplayed();
        if (lastNameVisible){
            driver.findElement(By.name("firstname")).sendKeys("test");
            driver.findElement(By.name("lastname")).sendKeys("syam");
            driver.findElement(By.name("jobtitle")).sendKeys("tester");
            driver.findElement(By.name("email")).sendKeys("syam.s@test.com");
            driver.findElement(By.name("phone")).sendKeys("2321421");
            driver.findElement(By.name("company")).sendKeys("testcompany");
            Select industry = new Select(driver.findElement(By.name("industry")));
            List<WebElement> industrySelector = industry.getOptions();


            for (int j =0;j<industrySelector.size();j++){
                System.out.println(industrySelector.get(j).getText());
            }
        }
    }

}
