package WebPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class select_Product {
    protected WebDriver driver;

    // constructor
    public select_Product(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    public WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    public WebElement secondProduct;

    @FindBy(xpath = "//*[@id=\"continue-shopping\"] ")
    public WebElement continueShopping;

    @FindBy(xpath ="//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    public WebElement thirdProduct;

    @FindBy(xpath ="//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    public WebElement fourthProduct;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    public WebElement fifthProduct;

    @FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a ")
    public WebElement checkOutCart;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-bike-light\"]")
    public WebElement remove_1_Product;


    //validation
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement products;

}
