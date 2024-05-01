package section4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HandlingTabsAndPopups {

    @Test
    public void handlingTabsAndPopupsTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        Page popup = page.waitForPopup(() -> {
            page.locator("text=Privacy Policy").nth(0).click();
        });

        popup.locator("//*[@id=\"header-sign-up-btn\"]").click();

        popup.locator("[value=email]").click();

        popup.locator(("#user_name")).fill("username");

        popup.close();
        page.close();
        browser.close();
        playwright.close();
    }

}
