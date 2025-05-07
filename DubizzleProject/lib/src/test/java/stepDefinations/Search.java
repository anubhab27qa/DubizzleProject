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

    @Given("I am on dubizzle Home page")
    public void I_am_on_dubizzle_Home_page() throws InterruptedException {
        homePagePOM.handleHomePagePopUp();
        homePagePOM.verifyHomePageTitle();
    }

    @And("I Search for {string} car")
    public void I_search_for_car(String carName) throws InterruptedException {
        homePagePOM.keywordSearch(carName);
    }

    @Then("I should see the search refine page having {string}")
    public void I_should_see_the_search_refine_page_having(String keyword) throws InterruptedException {
        homePagePOM.verifySearchSuggestions();
        searchRefinePOM.verifyKeyword(keyword);
    }

    @Then("Select {string} from suggestions drop down")
    public void select_dodge_challenger_from_suggestions_dropdown(String model) throws InterruptedException {
    	homePagePOM.chooseFromSearchSuggestionbox(model);
    }
}
