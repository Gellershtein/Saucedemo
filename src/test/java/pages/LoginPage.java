package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

@Log4j2
public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test = error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    @Override
    public void open() {
        log.info("Opening the Login page");
        driver.get(URL);
    }

    public boolean isOpened() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Login by user: {user}")
    public void logIn(String user, String password) {
        log.info("Filling data in Login form");;
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
