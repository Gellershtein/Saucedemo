package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    String PRODUCT_NAME = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);

        productsPage.addToCart(PRODUCT_NAME);
        String productPrice = productsPage.getProductPrice(PRODUCT_NAME);
        //TODO validate name and price
        cartPage.open();
        String productPriceInCart = cartPage.getProductPrice(PRODUCT_NAME);
        assertEquals(productPrice, productPriceInCart, "Prices are not equal");
    }

}
