package WebPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class checkoutOverview {
    protected WebDriver driver;

    //constructor
    public checkoutOverview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }



    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueBtn;


    @FindBy(xpath ="//*[@id=\"finish\"]")
    public WebElement finishBtn;


    //validation
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement Checkout_Overview;

}
