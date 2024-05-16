package section12;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestSkip {

    @Test
    public void skipTest() {

        throw new SkipException("Skipping the test as the condition is not met");

    }

}
