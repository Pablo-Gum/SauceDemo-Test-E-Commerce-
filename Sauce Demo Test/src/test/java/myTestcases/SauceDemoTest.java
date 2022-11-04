package myTestcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.WebFunctions;
import utilities.WebUtilities;
import utilities.readFile;
import utilities.reports.reporting;

public class SauceDemoTest {

    public WebUtilities webutilities = new WebUtilities();
    public WebFunctions webfunctions = new WebFunctions();
    public reporting repo = new reporting();


    String URL,Browser;
    ExtentReports reports;

    @BeforeTest
    @Parameters({"saucedemoURL","sBrowser"})
    public void init(String saucedemoURL,String sBrowser) {

         URL = saucedemoURL;
         Browser= sBrowser;
         webutilities.setDriver(webutilities.initializeWebDriver(Browser));
         webutilities.navigate(URL);
         reports = repo.initializeReports("logs/report.html");
         }

    @Test
    public void saucedemoRunner() throws FilloException {

        // read data from the Excel File
        readFile readfile = new readFile();
        Recordset rs = readfile.getData("resources/testdata/sauceDemo data.xlsx", "Select * From Login");
        Recordset rs2 = readfile.getData("resources/testdata/sauceDemo data.xlsx", "Select * From CheckOut");

        ExtentTest test = reports.createTest("Sauce Demo Test");
        test.assignAuthor("Mogau Pavlov Malepe");
        ExtentTest node;

        // loop through the data on the file while executing
        while (rs.next() && rs2.next()) {
            node = test.createNode("Sauce Demo: "+ rs.getField("UserName"));

            // check if log in details are valid
            boolean loggedin = webfunctions.login(node,WebUtilities.getDriver(), rs.getField("UserName"), rs.getField("Password"));
            if(!loggedin) {
                WebUtilities.getDriver().navigate().refresh();
                continue;
            }

            webfunctions.selectProduct(WebUtilities.getDriver(),node);
            boolean checkoutSuccessful = webfunctions.checkOut(WebUtilities.getDriver(),node,rs2.getField("FirstName"),rs2.getField("LastName"),rs2.getField("PostalCode"));
            System.out.println("check out Value "+checkoutSuccessful);

            if(!checkoutSuccessful){
                continue;
            }

            webfunctions.checkoutOverview(WebUtilities.getDriver(),node);
            webfunctions.logOut(WebUtilities.getDriver(),node);

        }// end while loop

    }
    @AfterTest
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        WebUtilities.getDriver().close();
        reports.flush();

    }




}// end class