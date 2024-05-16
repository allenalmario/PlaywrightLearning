package section12;

import org.testng.Assert;

public class TestFailure {

    public void doLogin() {
        Assert.fail("Failed to do login");
    }

}
