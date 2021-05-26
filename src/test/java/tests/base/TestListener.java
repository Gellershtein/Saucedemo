package tests.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //TODO CREATE TEST RUN USING API (add test cases too)
    public void onStart(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
        System.out.println(String.format("Test started: %s", result.getName()));
    }

    //TODO API REQUEST TO SET STATUS OF TEST CASE
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        System.out.println(String.format("Test failed: %s", result.getName()));
    }
}
