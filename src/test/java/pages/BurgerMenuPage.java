package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage extends BasePage {

    public static final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By BURGER_LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static final By BURGER_ABOUT_BUTTON = By.id("about_sidebar_link");
    public static final By SAUCELABS_LINK = By.id("about_sidebar_link");

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutBurgerMenu() {
        driver.findElement(BURGER_LOGOUT_BUTTON).click();
    }

    public void clickBurgerMenu() {
        driver.findElement(BURGER_MENU_BUTTON).click();
    }

    public String getLink() {
        return driver.findElement(SAUCELABS_LINK).getAttribute("href");
    }
}