package section12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

    @Test
    public void validateTitles() {

        String expected_title = "Yahoo.com";
        String actual_title = "Gmail.com";

//        Assert.assertEquals(expected_title, actual_title);

        boolean elementIsPresent = false;
        Assert.assertTrue(elementIsPresent, "Element was present!");
//         Assert.fail("Failing the test as the condition is not met");
    }

}
