package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    String PRODUCT_NAME = "Test.allTheThings() T-Shirt (Red)";

    @Test(description = "Product should be added to cart")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);

        productsPage.addToCart(PRODUCT_NAME);
        String productPrice = productsPage.getProductPrice(PRODUCT_NAME);
        //TODO validate name and price
        cartPage.open();
        String productPriceInCart = cartPage.getProductPrice(PRODUCT_NAME);
        String productNameInCart = cartPage.getProductName();
        assertEquals(productPrice, productPriceInCart, "Price is not equal");
        assertEquals(productNameInCart, PRODUCT_NAME, "Name is not equal");
    }
}
