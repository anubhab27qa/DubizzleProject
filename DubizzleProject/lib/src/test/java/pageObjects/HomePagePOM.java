package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.BaseClass;
import utilities.PageActions;

public class HomePagePOM {

	private WebDriverWait wait;

	public HomePagePOM() {
		PageFactory.initElements(BaseClass.getDriver(), this);
		wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
	}

	// ===== Web Elements =====

	@FindBy(id = "optInText")
	private WebElement allowPopUp;

	@FindBy(css = "[data-testid='dubizzle-logo']")
	private WebElement dubizzleLogo;

	@FindBy(css = "h1[data-testid='hero-title']")
	private WebElement homePageTitle;

	@FindBy(css = "[data-testid='search-input'] input")
	private WebElement searchInput;

	@FindBy(css = "ul[class*='MuiAutocomplete-listbox']")
	private WebElement suggestionDropdown;

	@FindBy(xpath = "//*[@data-testid='search-result']")
	private List<WebElement> suggestionListItems;

	@FindBy(css = "button[data-testid='search-button']")
	private WebElement btnSearch;

	// ===== Actions =====

	public void handleHomePagePopUp() {
		try {
			if (allowPopUp.isDisplayed()) {
				PageActions.clickElement(allowPopUp);
				PageActions.clickElement(dubizzleLogo);
			}
		} catch (Exception e) {
			System.out.println("Pop-up not found or already closed.");
		}
	}

	public void verifyHomePageTitle() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(homePageTitle));
		String expectedText = "The best place to buy your house, sell your car or find a job in Dubai";
		assertEquals(expectedText, homePageTitle.getText());
	}

	public void keywordSearch(String searchTerm) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(searchTerm);

	}

	public void verifySearchSuggestions() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(suggestionDropdown));
		assertTrue(suggestionDropdown.isDisplayed(), "Suggestion dropdown is not visible.");

		PageActions.clickElement(btnSearch);
	}

	public void chooseFromSearchSuggestionbox(String model) throws InterruptedException {
		Thread.sleep(2000);
		for (WebElement item : suggestionListItems) {
			if (item.getText().toLowerCase().contains(model)) {
				wait.until(ExpectedConditions.elementToBeClickable(item)).click();
				break;
			}
		}
	}
}
