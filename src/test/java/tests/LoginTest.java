package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

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
