package section5;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingShadowRootElements {

    @Test
    public void handlingShadowRootElementsTest() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://books-pwakit.appspot.com/explore?q=");

        // playwright handles shawdow dom elements automatically
        page.locator("#input").type("Java");

    }

}
