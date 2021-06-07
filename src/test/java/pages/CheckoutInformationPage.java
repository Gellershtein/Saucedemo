package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutInformationPage extends BasePage {
    //BUTTONS
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    //CHECKOUT FORM
    public static final By FIRST_NAME_FIELD = By.id("first-name");
    public static final By LAST_NAME_FIELD = By.id("last-name");
    public static final By ZIPCODE_POSTALCODE_FIELD = By.id("postal-code");
    public static final By CHECKOUTERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By PAGE_TITLE = By.cssSelector("[class='title']");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL + "/checkout-step-one.html");
    }

    public String isOpened() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Fill in checkout form")
    public void fillingCheckoutInformation(String firstName, String lastName, String postalCode) {
        log.info("Filling in checkout form");
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIPCODE_POSTALCODE_FIELD).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getCheckoutErrorMessage() {
        return driver.findElement(CHECKOUTERROR_MESSAGE).getText();
    }
}
