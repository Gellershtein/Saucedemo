package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    String addToCartButton = "//*[contains(text(), '%s')]/ancestor::*[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String name) {
        driver.findElement(By.xpath(String.format(addToCartButton, name))).click();
    }
}
