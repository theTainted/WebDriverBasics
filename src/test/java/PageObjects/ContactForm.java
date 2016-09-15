package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.sql.Timestamp;
import java.util.List;

/* Created by Syam on 10-09-2016.
*/
public class ContactForm {
    @FindBy(name = "firstname")
    public WebElement txtBoxFirstName;
    @FindBy(name = "lastname")
    public WebElement txtBoxLastName;
    @FindBy(name = "jobtitle")
    public WebElement txtBoxJobTitle;
    @FindBy(name = "email")
    public WebElement txtBoxEmail;
    @FindBy(name = "phone")
    public WebElement txtBoxPhone;
    @FindBy(name = "company")
    public WebElement txtBoxCompany;
    @FindBy(name = "industry")
    public WebElement selectIndustry;
    @FindBy(name = "segment")
    public WebElement selectSegment;
    @FindBy(name = "segmentation_Merchants_Financial_Service_Providers")
    public WebElement selectSegmentForFinancialServiceProviders;
    @FindBy(name="segmentation_Merchants_Service_Providers")
    public WebElement selectMerchantServiceProviderSegement;

    @FindBy(name = "online_sales_volume__c")
    public WebElement selectVolumeOfSales;
    @FindBy(name = "hq")
    public WebElement selectHeadQuarters;
    @FindBy(name = "message")
    public WebElement txtBoxMessage;
    @FindBy(xpath = "//div[@id='mainContainer']//span[@class='label']")
    public WebElement btnSubmit;
    @FindBy(xpath="//div[@id='mainContainer']//h1")
    public WebElement thankyouPage;

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public ContactForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setFirstName(String firstName) {
        txtBoxFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txtBoxLastName.sendKeys(lastName);
    }

    public void setJobTitle(String jobTitle) {
        txtBoxJobTitle.sendKeys(jobTitle);
    }

    public void setEmail(String email) {
        txtBoxEmail.sendKeys(email);
    }

    public void setCompany(String company) {
        txtBoxCompany.sendKeys(company);
    }

    public void setPhone(String phoneNumber) {
        txtBoxPhone.sendKeys(phoneNumber);
    }

    public void selectIndustry(int industryDropDownIndex) {
         /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
           now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select industry = new Select(selectIndustry);
        List<WebElement> industrySelector = industry.getOptions();
        industry.selectByIndex(industryDropDownIndex);
    }

    public void selectSegment(int segmentDropDownIndex) {
         /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
           now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select segment = new Select(selectSegment);
        List<WebElement> segmentSelector = segment.getOptions();
        segment.selectByIndex(segmentDropDownIndex);
    }

    public void selectSegementForFinancialIndustry(int financialndstryDropDownIndex) {
          /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
          now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select financialSegment = new Select(selectSegmentForFinancialServiceProviders);
        List<WebElement> financialSegmentSelector = financialSegment.getOptions();
        financialSegment.selectByIndex(financialndstryDropDownIndex);
    }
    public void selectSegmentForMerchantsServicesProviders(int forMerchantsServiceProviders){
        /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
          now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select merchantServiceProviderSegment = new Select(selectMerchantServiceProviderSegement);
        List <WebElement> merchantServiceProviderSegementSelector = merchantServiceProviderSegment.getOptions();
        merchantServiceProviderSegment.selectByIndex(forMerchantsServiceProviders);
    }
    public void selectSalesVolume(int salesVolumeDropDownIndex) {
         /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
           now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select salesVolume = new Select(selectVolumeOfSales);
        List<WebElement> salesVolumeSelector = salesVolume.getOptions();
        salesVolume.selectByIndex(salesVolumeDropDownIndex);
    }

    public void countrySelector(int countryDropDownIndex) {
         /*The index will start from one,
          may be later we can try making the function more intelligent ,
         include looping and avoid passing the index
           now this is designed for me and for my ease
           use of Select is also so that if required we can loop when we update this method*/
        Select countrySelect = new Select(selectHeadQuarters);
        List<WebElement> headQuarterelector = countrySelect.getOptions();
        countrySelect.selectByIndex(countryDropDownIndex);
    }

    public void setMessageInMessageBox(String text) {
        txtBoxMessage.sendKeys(text + " : " + new Timestamp(System.currentTimeMillis()));
    }

    public Boolean clickSubmit() {
        Boolean elementPresent;
        btnSubmit.click();
        try {
            driver.findElement(By.xpath("//div[@id='mainContainer']//h1"));
            softAssert.assertNotNull(thankyouPage.getText(),"i dont think you are in the thank you page");
            softAssert.assertAll();
            return elementPresent = true;
        } catch (NoSuchElementException e) {
            return elementPresent = false;
        }


    }

    public void acceptCookies() {
        Boolean bValue = driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).isDisplayed();
        System.out.println(bValue);
        if (bValue) {
            driver.findElement(By.xpath("//div[@class='row']//a[@class='button accept']")).click();

        }
    }


    public void switchToFrame(int frameNumber) {
        driver.switchTo().frame(frameNumber);
    }

    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }
}