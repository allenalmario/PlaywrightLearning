package section12.customListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed Test - " + result.getName());
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("Capturing Screenshot for the failed test --" + result.getName());

    }

}
