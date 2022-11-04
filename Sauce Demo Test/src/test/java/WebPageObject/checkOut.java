package WebPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class checkOut {
    protected WebDriver driver;

    public checkOut(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);

    }
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    public WebElement  firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    public WebElement lastName;

    @FindBy(xpath ="//*[@id=\"postal-code\"]")
    public WebElement postalCode;


    @FindBy(xpath = "//*[@id=\"checkout\"]")
    public WebElement checkOutBtn;


    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")
    public WebElement errorMessageBox;



}
