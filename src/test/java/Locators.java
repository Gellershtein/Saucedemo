import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {

    @Test
    public void locators() {
        WebDriver driver = new ChromeDriver();
        ///Page https://www.saucedemo.com/
        driver.findElement(By.id("user-name")); //User name Locator by.id(id="user-name")
        driver.findElement(By.name("password"));//Password Locator by.name(name="password")
        driver.findElement(By.className(".submit-button"));  //Login button

        //Page https://www.saucedemo.com/inventory.html
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("LinkedIn"));//bottom button
        driver.findElement(By.partialLinkText("Facebook"));//bottom button
        driver.findElement(By.xpath("//li[@attribute='class']"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//button[contains(@attribute,'data-t')]"));
        driver.findElement(By.xpath("//*[contains(text(),'carry.allTheThings() with the sleek')]"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div"));
        driver.findElement(By.xpath("//footer//descendant::li"));
        driver.findElement(By.xpath("//*[@class='inventory_item']//following::button"));
        driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']//parent::div"));
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']//preceding::*"));
        driver.findElement(By.xpath("//div[@class='inventory_item_price' and text()='29.99']"));

        //CSS
        //https://www.saucedemo.com/cart.html
        driver.findElement(By.cssSelector(".inventory_item_price"));
        driver.findElement(By.cssSelector(".btn btn_secondary.back btn_medium"));
        driver.findElement(By.cssSelector(".btn btn_secondary.back btn_medium"));
        driver.findElement(By.cssSelector(".cart_item .cart_quantity"));
        driver.findElement(By.cssSelector("#item_4_title_link"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("button.checkout_button"));
        driver.findElement(By.cssSelector("[class=inventory_item_desc]"));
        driver.findElement(By.cssSelector("[data-test~=continue"));
        driver.findElement(By.cssSelector("[rel|=noref"));
        driver.findElement(By.cssSelector("img[src^='/static/media/SwagBot_Footer_graphic']"));
        driver.findElement(By.cssSelector("a[href$='Facebook']"));
        driver.findElement(By.cssSelector("img[src*='2e87acec.png']"));
    }
}
