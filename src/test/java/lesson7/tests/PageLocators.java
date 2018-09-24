package lesson7.tests;

import org.openqa.selenium.By;

public interface PageLocators {
    By searchField = By.id("search_query_top");
    By firstResult = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
}
