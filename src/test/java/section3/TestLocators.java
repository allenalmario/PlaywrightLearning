package section3;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TestLocators {

    @Test
    public void testLocatorsTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/v1/");

        // different locators
        page.locator("#user-name").fill("standard_user");
        //page.locator("[id='user-name']").type("standard_user");
        // setDelay method makes it seem like it is manually typing speed
        //page.type("id=user-name", "standard_user", new Page.TypeOptions().setDelay(100));
//        page.locator("[type='text']").type("standard_user");
        page.locator("#password").fill("secret_sauce");
    }

}
