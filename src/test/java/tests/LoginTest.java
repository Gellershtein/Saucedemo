package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @DataProvider(name = "Email Data")
    public Object[][] getloginData() {
        return new Object[][]{
                {"", PASSWORD, "Epic sadface: Username is required"},
                {USER, "", "Epic sadface: Password is required"},
                {USER, "asdasdas", "Epic sadface: Username and password do not match any user in this service"},
                {LOCKED_USER, PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Ignore
    @Test(description = "Negative Login check", dataProvider = "Email Data")
    public void userNameShouldBeRequiredDP(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.logIn(user, password);
        assertEquals(loginPage.getError(), errorMessage, "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.logIn("", PASSWORD);
        assertEquals(loginPage.getError(), "Epic sadface: Username is required", "Error message is not correct");
    }
}
