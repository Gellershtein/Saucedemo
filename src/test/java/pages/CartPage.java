package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Override
    public void open() {
        driver.get(URL + "/cart.html");
    }

    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButtonInCart, productName))).click();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(productPriceInCart, productName))).getText();
    }
    public String getProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public void checkoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
