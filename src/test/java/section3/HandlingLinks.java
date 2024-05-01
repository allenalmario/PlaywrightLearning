package section3;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingLinks {

    @Test
    public void HandlingLinksTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        // this will gather all the links on the page
//        Locator links = page.locator("a");
//
//        System.out.println(links.count());
//
//        for(int i = 0; i < links.count(); i++) {
//
//            System.out.println(links.nth(i).innerText()+"--- URL: ---"+links.nth(i).getAttribute("href"));
//
//        }

        Locator block = page.locator("//*[@id='www-wikipedia-org']/footer/nav");

        Locator blockLinks = block.locator("a");

        System.out.println(blockLinks.count());

        for(int i = 0; i < blockLinks.count(); i++) {

            System.out.println(blockLinks.nth(i).innerText()+"--- URL: ---"+blockLinks.nth(i).getAttribute("href"));

        }

    }

}
