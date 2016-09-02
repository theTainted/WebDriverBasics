package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Syam on 28-08-2016.
 */
public class SeleniumPageObjects {
    @FindBy(linkText = "Download")
    public WebElement lnkDownload;
    @FindBy(xpath = "//div[@id='header']/h1/a")
    public WebElement lnkHome;
    WebDriver driver;

    /*   public SeleniumPageObjects(){

       }


       public SeleniumPageObjects(WebDriver driver){
           PageFactory.initElements(driver,this);
       }*/
    public SeleniumPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void ClickDownload() {
        lnkDownload.click();
    }

    public void NavigateHome() {
        lnkHome.click();

    }

}
