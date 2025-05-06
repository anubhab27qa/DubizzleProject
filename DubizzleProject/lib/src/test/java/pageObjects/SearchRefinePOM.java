package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.BaseClass;
import utilities.PageActions;

public class SearchRefinePOM {

	private WebDriverWait wait;

	public SearchRefinePOM() {
		PageFactory.initElements(BaseClass.getDriver(), this);
		wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
	}


	// ===== Web Elements =====
	@FindBy(id = "keyword-autocomplete")
	private WebElement inKeyword;
	
	@FindBy(css = "[data-testid='seochip-/motors/used-cars/dodge']")
	private WebElement tagBrand;
	// ===== Actions =====


	public void verifyKeyword(String keyword) {
		wait.until(ExpectedConditions.visibilityOf(inKeyword));
		assertEquals(keyword.toLowerCase(), inKeyword.getAttribute("value").toLowerCase());
	}
	
}
