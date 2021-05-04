package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    //BUTTONS
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    String removeButtonInCart = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item']//button";
    String productPriceInCart = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item_label']//child::*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButtonInCart, productName))).click();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(productPriceInCart, productName))).getText();
    }
}
