package section9;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class CaptureScreenshot {

    @Test
    public void captureScreenShotTest() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.google.com/");

//        // generates a screenshot in folder screenshot named screenshot.png
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));

        page.locator("#APjFqb").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./screenshot/element_screenshot.png")));

    }

}
