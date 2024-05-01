package section3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

public class TestHandlingDropdowns {

    @Test
    public void testHandlingDropdownsTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        // select by value
//        page.selectOption("select", "it");

        // select by text
//        page.selectOption("select", new SelectOption().setLabel("Deutsch"));

        // select by index
        page.selectOption("select", new SelectOption().setIndex(1));

        // parent and child selector
        Locator values = page.locator("select > option");
        System.out.println(values.count());

        for (int i = 0; i < values.count(); i++) {
            System.out.println(values.nth(i).innerText()+"-------------"+values.nth(i).getAttribute("lang"));
        }

        page.close();
        playwright.close();
    }
}
