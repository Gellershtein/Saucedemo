package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BurgerMenuTest extends BaseTest {

    @Test (description = "Logout should navigate to Login page")
    public void logoutShouldNavigateToLogin() {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);
        burgerMenuPage.clickBurgerMenu();
        burgerMenuPage.clickLogoutBurgerMenu();
        boolean isOpened = loginPage.isOpened();
        assertTrue(isOpened, "Login Page is not opened");
    }

    @Test (description = "Check SauceLabs link")
    public void linkAboutShouldBeCorrect() {
        loginPage.open();
        loginPage.logIn(USER, PASSWORD);
        burgerMenuPage.clickBurgerMenu();
        assertEquals(burgerMenuPage.getLink(), "https://saucelabs.com/",
                "Saucelabs link is not correct");
    }
}
