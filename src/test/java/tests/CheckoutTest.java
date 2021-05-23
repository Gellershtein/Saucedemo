package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "Checkout Data")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", LASTNAME, POSTALCODE, "Error: First Name is required"},
                {FIRSTNAME, "", POSTALCODE, "Error: Last Name is required"},
                {FIRSTNAME, LASTNAME, "", "Error: Postal Code is required"},
        };
    }

    @Test(description = "Negative tests for Checkout page", dataProvider = "Checkout Data")
    public void inputInvalidDataIntoCheckoutForm(String firstName, String lastName, String postalCode, String errorMessage) {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);
        cartPage.open();
        cartPage.checkoutButton();
        checkoutInformationPage.fillingCheckoutInformation(firstName, lastName, postalCode);
        String errorCheckoutPage = checkoutInformationPage.getCheckoutErrorMessage();
        assertEquals(errorCheckoutPage, errorMessage,"Error message is not correct");
    }

    @Test(description = "Positive test for Checkout form")
    public void inputValidDataIntoCheckoutForm() {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);
        cartPage.open();
        cartPage.checkoutButton();
        checkoutInformationPage.fillingCheckoutInformation(FIRSTNAME, LASTNAME, POSTALCODE);
        String title = checkoutInformationPage.isOpened();
        assertEquals(title, "CHECKOUT: OVERVIEW", "Page was not opened");
    }
}
