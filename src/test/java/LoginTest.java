import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginAndAddToCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String nameBag = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        String priceBag = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//*[text()='" + nameBag + "']//following::button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String nameInCart = driver.findElement(By.id("item_4_title_link")).getText();
        String priceInCart = driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText();
        assertEquals(nameBag, nameInCart, "Item name is different");
        assertEquals(priceInCart, priceBag, "Item price is different");
    }
}
