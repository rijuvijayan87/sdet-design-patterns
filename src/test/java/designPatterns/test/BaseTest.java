package designPatterns.test;

import drivers.browsers.Browsers;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeTest
    public void setupDriver() {
        DriverFactory driverFactory = new DriverFactory();
        driverManager = driverFactory.getDriverManager(Browsers.CHROME);
        driver = driverManager.getDriver();
    }

    @AfterTest
    public void quitDriver() {
        driverManager.quitDriver();
    }
}
