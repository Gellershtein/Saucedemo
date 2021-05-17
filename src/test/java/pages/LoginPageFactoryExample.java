package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactoryExample extends BasePage {
    @FindBy(id = "user-name")
    WebElement userInput;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test = error]")
    WebElement errorMessage;

    public LoginPageFactoryExample(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public void logIn(String user, String pswrd) {
        userInput.sendKeys(user);
        password.sendKeys(pswrd);
        loginButton.click();
    }

    public String getError() {
        return errorMessage.getText();
    }
}
