package lesson5;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class SearchFunctionality {
    static WebDriver driver;
    static String URL = "http://automationpractice.com";

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Ignore
    @Test
    public void shouldFail() {
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.id("search_query_top")).submit();
        Assert.assertTrue("First result checking...",
                driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"))
                        .getText()
                        .contains("Dress1"));
    }

    @Test
    public void shouldVerifyFirstSearchResultByName() {
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.id("search_query_top")).submit();
        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"))
                        .getText(), containsString("Dress"));
    }
}
