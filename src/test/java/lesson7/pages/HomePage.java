package lesson7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    static WebDriver wd;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
    WebElement firstResult;

    void clearAndSearchBy(String value) {
        searchField.clear();
        searchField.sendKeys(value);
        searchField.submit();
    }
}
