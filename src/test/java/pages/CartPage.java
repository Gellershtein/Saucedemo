package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CartPage extends BasePage {
    //BUTTONS
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    String removeButtonInCart = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item']//button";
    String productPriceInCart = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item_label']//child::*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Cart page")
    @Override
    public void open() {
        log.info("Opening the Cart page");
        driver.get(URL + "/cart.html");
    }
    @Step("Remove product from Cart")
    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButtonInCart, productName))).click();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(productPriceInCart, productName))).getText();
    }

    public String getProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Click Checkout button")
    public void checkoutButton() {
        log.info("Clicking Checkout button");
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
