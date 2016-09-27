package TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 8/26/2016.
 */
public class duplicateCountries {

  //  public static void main(String [] args) throws InterruptedException, IOException {
    @Test
    public void testDuplicateCountries() throws IOException{


      //  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "false");
        //WebDriver driver = new FirefoxDriver();
       System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sUrl="https://www-ingenico-test-global.lostboys.nl/lar-es/epayments/contacto";
        driver.navigate().to(sUrl);
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    /*   Boolean bValue = driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).isDisplayed();
        if (bValue) {
            driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).click();
        }*/
        driver.switchTo().frame(0);
        driver.findElement(By.name("hq")).click();


        Select dropdown = new Select(driver.findElement(By.name("hq")));

        //Get all options
        List<WebElement> countrySelector = dropdown.getOptions();

        //Get the length
        System.out.println(countrySelector.size());
        File file = new File("C:/countries.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        file = new File("C:/countries.txt");
        for (int j = 0; j < countrySelector.size(); j++) {

            String content = countrySelector.get(j).getText();


            // if file doesnt exists, then create it

            if (!file.exists()) {
                file.createNewFile();
            }


            System.out.println(content);
            bw.write(content);
            bw.write("\r\n");
            System.out.println(j);


        }
        bw.close();
        driver.quit();
    }


    }


