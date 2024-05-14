package section9;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TraceViewer {

    @Test
    public void traceViewerTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));


        // from chrome browser launces a new page
        Page page = context.newPage();
        page.navigate("https://www.way2automation.com/");

        page.locator("//*[@id='menu-item-27580']/a/span[2]").hover();
        page.locator("//*[@id='menu-item-27592']/a").click();

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        page.close();
        context.close();
        playwright.close();

    }

}
