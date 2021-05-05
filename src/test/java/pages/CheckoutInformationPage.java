package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {
    //BUTTONS
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    //CHECKOUT FORM
    public static final By FIRST_NAME_FIELD = By.id("cancel");
    public static final By LAST_NAME_FIELD = By.id("last-name");
    public static final By ZIPCODE_POSTALCODE_FIELD = By.id("postal-code");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL + "/checkout-step-one.html");
    }
}
