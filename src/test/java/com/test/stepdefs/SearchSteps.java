package com.test.stepdefs;

import com.context.testcontext.TestContext;
import com.searchmodule.pages.GoogleSearchPage;
import com.searchmodule.pages.SearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import java.net.MalformedURLException;

public class SearchSteps{
    TestContext context;
    GoogleSearchPage googleSearchPage;
    public SearchSteps(TestContext context) {
        this.context =context;
        googleSearchPage = context.getGoogleSearchPage();
    }

    @Given("^I am on the website duck-duck-go$")
    public void launchSite() {
//        searchPage = new SearchPage(driver);
        context.getSearchPage().goTo();
    }

    @And("^I enter the \"([^\"]*)\" to search$")
    public void enterKeyword(String keyword) {
        context.getSearchPage().doSearch(keyword);
    }

    @And("^I navigate to videos search$")
    public void navigateTovideos()  {
        context.getSearchPage().goToVideos();
    }

    @Then("^I should get minimum \"([^\"]*)\" search results$")
    public void verifySearchResults(int min) {
        int size = context.getSearchPage().getResult();
        Assert.assertTrue(size > min);
    }

    @Given("^I am on the open browser and open google$")
    public void iAmOnTheOpenBrowserAndOpenGoogle() {
        googleSearchPage.goToGoogle();
    }

    @When("Then I search for {string} on google page")
    public void thenISearchForOnGooglePage(String arg0) {
        context.getSearchPage().doGoogleSearch(arg0);
    }
}