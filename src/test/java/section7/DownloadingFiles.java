package section7;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class DownloadingFiles {

    @Test
    public void downloadingFilesTest() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.selenium.dev/downloads/");


        Download file = page.waitForDownload(() -> {


            page.locator("body > div > main > div:nth-child(3) > div.col-sm-6.py-3.pl-0.pr-3 > div > div > p:nth-child(1) > a").click();
        });


        file.saveAs(Paths.get("./src/test/resources/selenium.jar"));

    }

    }