package section5;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingMouseOverMenus {

    @Test
    public void handlongMouseOverMenusTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/");

        page.locator("//*[@id='menu-item-27580']/a/span[2]").hover();
        page.locator("//*[@id='menu-item-27592']/a").click();

    }

}
