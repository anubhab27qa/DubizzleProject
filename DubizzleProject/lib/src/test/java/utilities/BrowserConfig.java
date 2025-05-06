package utilities;

import java.net.UnknownHostException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hooks.BaseClass;

public class BrowserConfig {

    public enum Browser {
        CHROME, FIREFOX, FIREFOX_HEADLESS, EDGE, HEADLESS
    }

    public static WebDriver setup(String browserType, String uri) throws UnknownHostException {
        WebDriver driver;

        switch (Browser.valueOf(browserType.toUpperCase())) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case FIREFOX_HEADLESS:
            case HEADLESS:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        configureDriver(driver, uri);
        return driver;
    }

    private static void configureDriver(WebDriver driver, String uri) throws UnknownHostException {
        BaseClass.driverLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(uri);
        PageActions.waitForPageToLoad();
    }
}
