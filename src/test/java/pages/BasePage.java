package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
    WebDriver driver;
    Select select;
    String URL;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(WebDriver driver, Select select) {
        this.driver = driver;
        this.select = select;
    }

    public void open() {
    }
}
