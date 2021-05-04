package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    //BUTTONS
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CANCEL_BUTTON = By.id("cancel");

    String productPriceInOverview = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item_label']//child::*[@class='inventory_item_price']";
    String productQuantityInOverview = "//*[contains(text(), '%s')]//ancestor::*[@class='cart_item']//child::*[@class='cart_quantity']";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void open() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }
}
