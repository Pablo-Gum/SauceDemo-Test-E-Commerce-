package WebPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login_Page {

    protected WebDriver driver;


    // Constructor
    public  Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }


    @FindBy(xpath = "//*[@id=\"user-name\"]")
    public WebElement Username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement Password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement loginButton;




}
