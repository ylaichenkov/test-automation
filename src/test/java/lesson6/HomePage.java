package lesson6;

import org.junit.*;
import pageObjects.BasePage;

public class HomePage {

    @BeforeClass
    public static void setUp() {
        String URL = "http://automationpractice.com";
        BasePage.setUp();
        BasePage.openPage(URL);
    }

    @AfterClass
    public static void tearDown() {
        BasePage.closeBrowser();
    }


    @Test
    public void shouldVerifyFirstSearchResultByName() {
        BasePage.searchField.sendKeys("Dress");
        BasePage.searchField.submit();
    }
}
