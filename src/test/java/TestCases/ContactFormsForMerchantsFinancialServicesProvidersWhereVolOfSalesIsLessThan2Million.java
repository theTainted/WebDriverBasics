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
public class ContactFormsForMerchantsFinancialServicesProvidersWhereVolOfSalesIsLessThan2Million {
    static String sURL = "https://www-ingenico-test-global.lostboys.nl/br/epayments/contato";

    public static void main(String[] args) throws InterruptedException, IOException {

        //  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(sURL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
 /*  Boolean bValue = driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).isDisplayed();
        System.out.println(bValue);
      if (bValue) {
            driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).click();

        }*/
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
            industry.selectByIndex(1);

            System.out.println(industry.getFirstSelectedOption().getText());
            Select segment = new Select(driver.findElement(By.name("segmentation_Merchants_Financial_Service_Providers")));
            List<WebElement> segmentSelector = segment.getOptions();
            for (int allSegments = 1; allSegments < segmentSelector.size(); allSegments++) {
                segment.selectByIndex(1);
                Select volumeOfSales = new Select(driver.findElement(By.name("online_sales_volume__c")));
                List<WebElement> volumeOfSalesSelector = volumeOfSales.getOptions();
                Thread.sleep(2000);
           /* for (int j =0;j<volumeOfSalesSelector.size();j++){
                 System.out.println(volumeOfSalesSelector.get(j).getText());}*/
                volumeOfSales.selectByIndex(1);

                Select headquarters = new Select(driver.findElement(By.name("hq")));
                headquarters.selectByIndex(1);

                driver.findElement(By.xpath("//div[@id='mainContainer']//span[@class='label']")).click();

                System.out.println(driver.findElement(By.xpath("//div[@id='mainContainer']//h1")).getText());
                //driver.navigate().to(sURL);

            }
        }
    }

}
