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
}
