package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInformationPage checkoutInformationPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected BurgerMenuPage burgerMenuPage;
    public static String USER = "standard_user";
    public static String LOCKED_USER = "locked_out_user";
    public static String PROBLEM_USER = "problem_user";
    public static String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    public static String PASSWORD = "secret_sauce";
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String LASTNAME = "LASTNAME";
    public static final String POSTALCODE = "123456";

    @Parameters({"browser"})
    @BeforeMethod(description = "Open browser")
    public void setUp(@Optional("chrome") String browser, String headless, ITestContext testContext) {
        browser = System.getProperty("BROWSER");
        headless = System.getProperty("HEADLESS");
        System.out.println(browser);
        System.out.println(headless);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
//        loginPage = new LoginPageFactory(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }
}

