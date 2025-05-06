package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.BaseClass;

public class PageActions {

    public static WebElement clickElement(WebElement element) throws InterruptedException {
        try {
            
            WebElement visibleElement = waitForVisibility(element);
            visibleElement.click();
            return visibleElement;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element Not Found: " + element, e);
        } catch (StaleElementReferenceException e) {
            throw new StaleElementReferenceException("Element is Stale: " + element);
        }
    }

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageToLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(30));
            wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.err.println("Error while waiting for page to load: " + e.getMessage());
        }
    }
}
