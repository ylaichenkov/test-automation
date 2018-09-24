package lesson7.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class CacheLookUpTest {

    static WebDriver wd;

    @BeforeClass
    public static void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, SECONDS);
        wd.manage().timeouts().implicitlyWait(10, SECONDS);

        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterClass
    public static void tearDown(){
        wd.quit();
    }

    @Test
    public void verifyFirstSearchResult() throws InterruptedException {
        String dressValue = "Dress";
        String tShirtValue = "T-shirts";
        HomePage page = new HomePage();


        page.clearAndSearchBy(dressValue);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElement(page.firstResult,dressValue));

        page.clearAndSearchBy(tShirtValue);
        (new WebDriverWait(wd,10))
                .until(textToBePresentInElement(page.firstResult, tShirtValue));
    }

    class HomePage {

        @FindBy(id = "search_query_top")
        @CacheLookup
        WebElement searchField;

        @FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
        @CacheLookup
        WebElement firstResult;

        public HomePage() {
            PageFactory.initElements(wd, this);
        }

        void clearAndSearchBy(String value) {
            searchField.clear();
            searchField.sendKeys(value);
        }
    }
}

