package section12;

import org.testng.annotations.*;

public class TestCase1 {

    @BeforeTest
    public void createDBConn() {
        // This method will run before all test cases are ran
        System.out.println("Creating Database connection.");
    }

    @AfterTest
    public void closeDBConn() {
        // This method will run after all test cases are ran
        System.out.println("Closing Database connection.");
    }

    @BeforeMethod
    public void launchBrowser() {
        // This method will run before every test case
        System.out.println("Launching browser.");
    }

    @AfterMethod
    public void closeBrowser() {
        // this method will run after every test case
        System.out.println("Closing browser.");
    }

    @Test(priority=2)
    public void doLogin() {
        System.out.println("Executing Login test");
    }

    @Test(priority=1)
    public void doUserReg(){
        System.out.println("Executing User Reg test");
    }
}
