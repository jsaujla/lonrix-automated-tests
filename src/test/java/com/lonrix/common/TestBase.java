package com.lonrix.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static final String JUNO_VIEWER_WEB_BASE_URL = "https://secure.junoviewerweb.com/";
    private static final long WAIT_TIME_IN_SECONDS = 15;

    private WebDriver driver;

    @BeforeTest
    public static void beforeAllTests() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeEachTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterEachTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, WAIT_TIME_IN_SECONDS);
    }

    protected Select getSelect(WebElement webElement) {
        return new Select(webElement);
    }

    protected JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    protected String getJunoViewerWebBaseUrl() {
        return JUNO_VIEWER_WEB_BASE_URL;
    }

}
