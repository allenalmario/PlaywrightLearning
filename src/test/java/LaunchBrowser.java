import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchBrowser {

    @Test
    public void launchBrowserTest() {

        // create method returns a Playwright object
        // here, creating an instance of Playwright class in 'playwright' variable
        Playwright playwright = Playwright.create();

        // launch method returns a Browser object
        // using the playwright instance's launch method to create a chrome browser instance and launch it
        // launch method takes BrowserType object using LaunchOptions method, calling setHeadless method and passing false
        // in order for a browser to show upon test execution
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // firefox
        // Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // setting the window size with Browser's newContext method in a BrowserContext instance
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 720));

        // newPage method returns a Page object
        // using the browser instance's newPage method to create a page instance
        Page page = browserContext.newPage();
        page.navigate("https://www.youtube.com/");
        Assert.assertEquals(page.title(), "YouTube");
        // close the page
        page.close();
        // close the session
        playwright.close();
    }

}
