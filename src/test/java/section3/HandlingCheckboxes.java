package section3;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingCheckboxes {

    @Test
    public void handlingCheckboxesTest() throws InterruptedException {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

        Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");

        Locator checkboxes = block.locator("[type='checkbox']");

        for (int i = 0; i < checkboxes.count(); i++) {
            checkboxes.nth(i).click();
        }

        Thread.sleep(5000);

        System.out.println(checkboxes.count());
        page.close();
        browser.close();
        playwright.close();

    }

}
