package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test (retryAnalyzer = Retry.class)
    public void loginShouldBeCorrect() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        boolean isError = loginPage.isErrorDisplayed();
        assertFalse(isError, "ERROR WAS DISPLAYED");
        //boolean opened = productsPage.isPageOpened();
        //assertTrue(opened, "AKDJASLPDALkdn");
    }

    @DataProvider(name = "Login Data")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"", PASSWORD, "Epic sadface: Username is required"},
                {USER, "", "Epic sadface: Password is required"},
                {USER, "asdasd", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test (description = "Negative tests for login", dataProvider = "Login Data")
    public void userNameShouldBeRequired(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        String error = loginPage.getError();
        assertEquals(error, errorMessage, "Error message is not correct");
    }
}
