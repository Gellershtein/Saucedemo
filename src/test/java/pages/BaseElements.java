package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseElements extends BasePage {
    //HEADER
    public static final By CART_ICON = By.id("shopping_cart_container");
    public static final By BURGER_MENU = By.id("react-burger-menu-btn");
    //FOOTER
    public static final By TWITTER_BUTTON = By.cssSelector(".social_twitter");
    public static final By FACEBOOK_BUTTON = By.cssSelector(".social_facebook");
    public static final By LINKEDIN_BUTTON = By.cssSelector(".social_linkedin");
    public static final By PRIVACY_POLICY_TEXT = By.cssSelector(".footer_copy");

    public BaseElements(WebDriver driver) {
        super(driver);
    }

    public BaseElements(WebDriver driver, Select select) {
        super(driver, select);
    }

}
