package section9;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class CapturingVideos {

    @Test
    public void capturingVideosTest() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

        Page page = context.newPage();

        page.navigate("https://www.google.com/");

        page.locator("#APjFqb").type("This is a video recording from Playwright!");

        page.close();
        context.close();
        playwright.close();

    }

}
