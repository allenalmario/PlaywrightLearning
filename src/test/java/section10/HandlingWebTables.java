package section10;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HandlingWebTables {

    @Test
    public void handlingWebTables() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.freecodecamp.org/news/html-tables-table-tutorial-with-css-example-code/");

        // row count
        System.out.println(page.locator("//*[@id='site-main']/div/article/section/div[1]/section/table[4]/tbody").locator("tr").count());

        // column count
        System.out.println(page.locator("//*[@id='site-main']/div/article/section/div[1]/section/table[4]/tbody").locator("tr:first-child").locator("th").count());

        assertThat(page.locator("//*[@id='site-main']/div/article/section/div[1]/section/table[4]/tbody").locator("tr:first-child").locator("th:nth-child(2)")).hasText("Semester");

        page.locator("//*[@id='site-main']/div/article/section/div[1]/section/table[4]/tbody").allInnerTexts().forEach(text -> System.out.println(text));
    }

}
