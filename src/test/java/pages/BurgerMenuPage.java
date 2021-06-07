package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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

    @Step("Click Burger menu")
    public void clickBurgerMenu() {
        log.info("Clicking Burger menu button");
        driver.findElement(BURGER_MENU_BUTTON).click();
    }
    @Step("Get link from Burger menu")
    public String getLink() {
        log.info("Getting link from Burger menu");
        return driver.findElement(SAUCELABS_LINK).getAttribute("href");
    }
}