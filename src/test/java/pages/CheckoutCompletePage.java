package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void open() {
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }
}
