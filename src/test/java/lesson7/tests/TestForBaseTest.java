package lesson7.tests;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class TestForBaseTest extends BaseTest{

    @Test
    public void verifyFirstSearchResult() throws InterruptedException {
        String dressValue = "Dress";
        String tShirtValue = "T-shirts";
        HomePage page = new HomePage();


        page.clearAndSearchBy(dressValue);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(page.firstResult, dressValue));

        page.clearAndSearchBy(tShirtValue);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElementLocated(page.firstResult, tShirtValue));
    }

    class HomePage {


        By searchField = By.id("search_query_top");
        By firstResult = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");


        public HomePage() {
            PageFactory.initElements(wd, this);
        }

        void clearAndSearchBy(String value) {
            $(searchField).clear();
            $(searchField).sendKeys(value);
        }

        WebElement $(By locator) {
            return wd.findElement(locator);
        }
    }
}

