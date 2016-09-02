package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Syam on 21-08-2016.
 */
public class HomePage {
    @FindBy(name = "q")
    public WebElement txtSearch;
    @FindBy(name = "btnG")
    public WebElement btnSearch;
    @FindBy(xpath = "//div[@id='rso']//div[@class='rc']/h3[@class='r']/a")
    public WebElement lnkSelenium;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        //   this.driver =driver;

        PageFactory.initElements(this.driver, this);


    }

    public void SearchGoogle(String searchGoogle) {
        txtSearch.sendKeys(searchGoogle);
        btnSearch.click();
    }

    public SeleniumPageObjects clickSelenium() {
        lnkSelenium.click();
        return new SeleniumPageObjects(this.driver);
    }
}
