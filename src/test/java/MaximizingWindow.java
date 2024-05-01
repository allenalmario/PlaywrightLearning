import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MaximizingWindow {

    @Test
    public void maximizingWindowTest () {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        Page page = context.newPage();
        page.navigate("https://www.youtube.com/");
    }

}
