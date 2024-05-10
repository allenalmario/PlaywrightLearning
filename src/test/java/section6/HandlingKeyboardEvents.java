package section6;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingKeyboardEvents {

    @Test
        public void handlingKeyboardEventsTest() throws InterruptedException {
            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://login.yahoo.com/");

            page.locator("#login-username").type("tom@myspace.com", new Locator.TypeOptions().setDelay(100));

            page.keyboard().press("Enter");
            Thread.sleep(1000);
            page.goBack();
            page.keyboard().press("Alt+A");
            Thread.sleep(1000);
            page.keyboard().press("Alt+X");
            Thread.sleep(1000);
            page.keyboard().press("Alt+V");
            Thread.sleep(1000);
            page.keyboard().down("Shift");

            for (int i=0; i<3; i++) {
                page.keyboard().press("ArrowLeft");
                Thread.sleep(500);
            }
    }

}
