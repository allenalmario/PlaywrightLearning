package section5;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingDragAndDrop {

    @Test
    public void handlingDragAndDropTest() {

        Playwright playwright = Playwright.create();
        // launching a chrome browser
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // from chrome browser launces a new page
        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");

        // locator of element to be dragged
        Locator draggable = page.locator("#draggable");

        // locator of where element is to be dragged to
        Locator droppable = page.locator("#droppable");

        // get center point of draggable
        page.mouse().move(draggable.boundingBox().x + draggable.boundingBox().width/2, draggable.boundingBox().y + draggable.boundingBox().height/2);

        // press down on the draggable element itself
        page.mouse().down();

        // move to center point of droppable
        page.mouse().move(droppable.boundingBox().x + droppable.boundingBox().width/2, droppable.boundingBox().y + droppable.boundingBox().height/2);

        // let go of the slider itself
        page.mouse().up();
    }

}
