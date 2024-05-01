package section4;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingAlerts {

    @Test
    public void handlingAlertsTest() throws InterruptedException {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");

        // this is a listener which is emmited/invoked when a javascript dialog appears
        page.onceDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // when the popup appears, this will accept the alert
            dialog.accept();
            System.out.println(dialog.message());
        });

        Thread.sleep(2000);

        page.locator("[type='submit']").click();
        page.close();
        browser.close();
        playwright.close();

    }

}
