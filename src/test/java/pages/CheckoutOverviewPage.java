package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
    @Step("Open Checkout Overview Page page")
    public void open() {
        log.info("Opening the Checkout Overview Page");
        driver.get(URL + "/checkout-step-two.html");
    }
}
