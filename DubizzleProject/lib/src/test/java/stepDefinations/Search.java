package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePOM;
import pageObjects.SearchRefinePOM;

public class Search {

    private HomePagePOM homePagePOM;
    private SearchRefinePOM searchRefinePOM;

    public Search() {
        homePagePOM = new HomePagePOM(); 
        searchRefinePOM=new SearchRefinePOM();
    }

    @Given("User is on dubizzle Home page")
    public void user_is_on_dubizzle_home_page() throws InterruptedException {
        homePagePOM.handleHomePagePopUp();
        homePagePOM.verifyHomePageTitle();
    }

    @When("User clicks on {string} as category")
    public void user_clicks_on_category(String category) throws InterruptedException {
        homePagePOM.chooseCategory(category);
    }

    @And("User Searches for {string} car")
    public void user_searches_for_car(String carName) throws InterruptedException {
        homePagePOM.keywordSearch(carName);
    }

    @Then("User should see the search refine page having {string}")
    public void search_suggestions_dropdown_should_be_visible(String keyword) throws InterruptedException {
        homePagePOM.verifySearchSuggestions();
        searchRefinePOM.verifyKeyword(keyword);
    }

    @Then("Select {string} from suggestions drop down")
    public void select_dodge_challenger_from_suggestions_dropdown(String model) throws InterruptedException {
    	homePagePOM.chooseFromSearchSuggestionbox(model);
    }
}
