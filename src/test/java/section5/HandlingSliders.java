package section5;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingSliders {

    @Test
    public void handlingSlidersTest() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

        Locator slider = page.locator("//*[@id='slider']/span");

        // locate the middle of the slider button itself
        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y + slider.boundingBox().height/2);

        // press down on the slider itself
        page.mouse().down();

        // move the slide down the x axis 400 pixels
        page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y + slider.boundingBox().height/2);

        // let go of the slider itself
        page.mouse().up();

    }

}
