package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static WebDriver driver;
    public static WebElement searchField = driver.findElement(By.id("search_query_top"));


    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
