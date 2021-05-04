package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginAndAddToCart() {
        loginPage.open();
        loginPage.logIn("standard_user", "secret_sauce");

        String nameBag = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        String priceBag = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//*[text()='" + nameBag + "']//following::button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String nameInCart = driver.findElement(By.id("item_4_title_link")).getText();
        String priceInCart = driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText();
        assertEquals(nameBag, nameInCart, "Item name is different");
        assertEquals(priceInCart, priceBag, "Item price is different");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.logIn("", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username is required", "Error message is not correct");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.logIn(USER, "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required", "Error message is not correct");
    }

    @Test
    public void loginAndPasswordShouldBeCorrect() {
        loginPage.open();
        loginPage.logIn("wrongUser", "wrongPassword");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service", "Error message is not correct");
    }

    @Test
    public void lockedOutUserShouldNotAccessToLogin() {
        loginPage.open();
        loginPage.logIn("locked_out_user", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.", "Error message is not correct");
    }
}
