package utilities;

import WebPageObject.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.reports.reporting;

public class WebFunctions extends WebActions{

    reporting repo = new reporting();
    String fileName;



    // login method
    public boolean login(ExtentTest node, WebDriver driver, String Username, String Password)
    {
        Login_Page loginObj = new Login_Page(driver);
        boolean loggedin = false;

        try{

            sendKeysObject(loginObj.Username,driver,Username);
            sendKeysObject(loginObj.Password,driver,Password);
            clickObject(loginObj.loginButton,driver);

            fileName = repo.captureScreenshot(driver);

            //validation
            if(driver.getCurrentUrl().contains("inventory.html")){
                loggedin = true;
                node.pass("Logged in successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }else {
                node.fail("Failed to log in",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());

            }

        }catch (Exception e){
            System.out.println("Login unsuccessful"+ e.getMessage());
            Assert.fail();
        }

        return  loggedin;
    }

    // selecting a product method
    public void selectProduct(WebDriver driver, ExtentTest node){
        select_Product selectProductObj = new select_Product(driver);

        try{
            clickObject(selectProductObj.firstProduct,driver);
            clickObject(selectProductObj.secondProduct,driver);
            clickObject(selectProductObj.thirdProduct,driver);
            clickObject(selectProductObj.fourthProduct,driver);
            clickObject(selectProductObj.fifthProduct,driver);

            //validation
            if(selectProductObj.products.isDisplayed()){
                node.pass("products page successful",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }else{
                node.fail("Products Page unsuccessful",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }

            clickObject(selectProductObj.checkOutCart,driver);
            clickObject(selectProductObj.remove_1_Product,driver);

        }catch(Exception e){
            System.out.println("Please select different products"+ e.getMessage());
            Assert.fail();
        }

    }

    //checking out method
    public boolean checkOut(WebDriver driver,ExtentTest node,String FirstName,String LastName,String PostalCode) {
        checkOut checkoutObj = new checkOut(driver);
        boolean checkoutSuccessful = false;


        try {
            clickObject(checkoutObj.checkOutBtn, driver);

            sendKeysObject(checkoutObj.firstName, driver, FirstName);
            sendKeysObject(checkoutObj.lastName, driver, LastName);
            sendKeysObject(checkoutObj.postalCode, driver, PostalCode);
            Thread.sleep(5000);



            //validation check if last name is populated
            fileName = repo.captureScreenshot(driver);
            if (checkoutObj.lastName.getAttribute("value").contains(LastName)) {
                checkoutSuccessful = true;
                node.pass(" Your checkout information is successful", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            } else {
                node.fail("Last Name is a required field ", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
                logOut(driver, node);
            }



        } catch (Exception e) {
            System.out.println("check out unsuccessful" + e.getMessage());
            Assert.fail();
        }
        return checkoutSuccessful;


    }

    // check out cart overview method
    public void checkoutOverview(WebDriver driver,ExtentTest node){
        checkoutOverview checkoutOverviewObj = new checkoutOverview(driver);

        try{

            clickObject(checkoutOverviewObj.continueBtn, driver);
            Thread.sleep(5000);

            //validation
            fileName = repo.captureScreenshot(driver);
            if (checkoutOverviewObj.Checkout_Overview.isDisplayed()) {
                node.pass("Checkout_Overview page is successful", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            } else {
                node.fail("Checkout_Overview page unsuccessful ", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }

            clickObject(checkoutOverviewObj.finishBtn, driver);

        }catch(Exception e){
            System.out.println("Check Out Over view unsuccessful"+ e.getMessage());
            Assert.fail();
        }

    }

    //LogOut Method
    public void logOut(WebDriver driver,ExtentTest node){
        LogOut_Page logOutObj = new LogOut_Page(driver);

        try {
            clickObject(logOutObj.dropDownBtn, driver);
            Thread.sleep(5000);
            clickObject(logOutObj.logOutBtn,driver);

            fileName = repo.captureScreenshot(driver);
            //Validation
            if(logOutObj.credentials.isDisplayed()){
                node.pass("Logged out Successful",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }else{
                node.fail("log out unsuccessful",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            }


        }catch (Exception e){
            System.out.println("LogOut unsuccessful"+ e.getMessage());
            Assert.fail();
        }
    }



}
