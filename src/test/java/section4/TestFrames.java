package section4;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TestFrames {

    @Test
    public void testFramesTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        page.frameLocator("[name='iframeResult']").locator("body > button").click(new Locator.ClickOptions().setTimeout(2000));

        Locator frames = page.locator("iframe");

        System.out.println(frames.count());

        for (int i = 0; i < frames.count(); i++) {
            System.out.println(frames.nth(i).getAttribute("id"));
        }

        page.close();
        browser.close();
        playwright.close();

    }

}
