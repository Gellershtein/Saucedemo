package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BaseElements {

    public static final By SORT_PRODUCTS_FILTER = By.cssSelector(".product_sort_container");
    String addToCartButton = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//button";
    String productPrice = "//*[contains(text(), '%s')]//ancestor::*[@class='inventory_item']//child::*[@class='inventory_item_price']";
    public static final By SORT_FILTER_ELEMENT = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver, Select select) {
        super(driver, select);
    }

    @Override
    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartButton, productName))).click();
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(productPrice, productName))).getText();
    }

    //DRAFT
    public void choseSortFilter(String sortValue) {
        new Select(driver.findElement(SORT_FILTER_ELEMENT));
        List<WebElement> sortFilterOptionsList = select.getOptions();
//        for (int i = 0; i < sortFilterOptionsList.size(); i++) {
//            if (sortFilterOptionsList.get(i))
//        }
//sortFilterOptionsList.get(sortFilterOptionsList.indexOf(sortFilterOptionsList.contains(sortValue))).click();
    }

}
