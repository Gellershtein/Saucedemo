package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutCompletePage extends BasePage {
    //BUTTONS
    public static final By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    //TEXTS
    public static final By COMPLETE_HEADER_TEXT = By.cssSelector(".complete-header");
    public static final By COMPLETE_TEXT = By.cssSelector(".complete-text");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }


    @Override
    @Step("Open Checkout Complete Page page")
    public void open() {
        log.info("Opening the Checkout Complete Page");
        driver.get(URL + "/checkout-complete.html");
    }
}
