package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Syam on 21-08-2016.
 */
public class homePage {
    public homePage(WebDriver driver){
        PageFactory.initElements(driver,this);


}
    @FindBy(name = "q")
    public WebElement txtSearch;

    @FindBy(name="btnG")
    public WebElement btnSearch;

    public  void SearchGoogle(String searchGoogle){
        txtSearch.sendKeys(searchGoogle);
        btnSearch.click();
    }
}
