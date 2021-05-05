package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
    WebDriver driver;
    public static String URL = "https://www.saucedemo.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
    }
}
