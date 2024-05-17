package section14;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExtentReports {

    public ExtentSparkReporter htmlReporter; // create html file and add configuration
    public ExtentReports extent; // Attaching reporter, Creating test cases and other system config.
    public ExtentTest test; // maintaining the test cases, adding logs status pass/fail/skipped

    @BeforeTest
    public void  setReport() {

        htmlReporter = new ExtentSparkReporter("./reports/extent.html");

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Extent Report Status");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester", "Allen");
        extent.setSystemInfo("Build No:", "1234");
        extent.setSystemInfo("Organization", "The Company Inc");

    }

    @Test
    public void doLogin() {

        test = extent.createTest("Login Test");
        test.log(Status.INFO, "Entering username");
        test.log(Status.INFO, "Entering password");


    }

    @Test
    public void doUserReg() {

        test = extent.createTest("User Registration Test");
        test.log(Status.INFO, "Filling form");
        Assert.fail();

    }

    @Test
    public void isSkipTest() {

        test = extent.createTest("Skip Test");
        test.log(Status.INFO, "Entering some data");
        throw new SkipException("Skip the test");
    }

    @AfterMethod
    public void updateResults(ITestResult result) {

        if (result.getStatus()==ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            Markup m = MarkupHelper.createLabel("Test case failed: " + methodName.toUpperCase(), ExtentColor.RED);
            test.fail(m);
        }
        else if (result.getStatus()==ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            Markup m = MarkupHelper.createLabel("Test case pass: " + methodName.toUpperCase(), ExtentColor.GREEN);
            test.pass(m);
        }
        else if (result.getStatus()==ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            Markup m = MarkupHelper.createLabel("Test case skip: " + methodName.toUpperCase(), ExtentColor.AMBER);
            test.skip(m);
        }

    }

    @AfterTest
    public void endReport() {

        extent.flush();

    }

}
