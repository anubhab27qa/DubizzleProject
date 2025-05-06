package hooks;

import java.net.UnknownHostException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriverException;
import utilities.BrowserConfig;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    public static void initDriver() {
        if (driverLocal.get() == null) {
            try {
                WebDriver driver = BrowserConfig.setup("chrome", "https://dubai.dubizzle.com/");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driverLocal.set(driver);
            } catch (UnknownHostException e) {
                System.err.println("Unable to reach the host. Please check the URL.");
                e.printStackTrace();
            } catch (WebDriverException e) {
                System.err.println("WebDriver initialization failed: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Unexpected error during driver initialization.");
                e.printStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverLocal.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        try {
            WebDriver driver = driverLocal.get();
            if (driver != null) {
                driver.quit();
                driverLocal.remove();
            }
        } catch (WebDriverException e) {
            System.err.println("Error occurred while quitting the WebDriver.");
            e.printStackTrace();
        }
    }
}
