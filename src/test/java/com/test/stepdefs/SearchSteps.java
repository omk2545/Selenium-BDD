package com.test.stepdefs;

import com.context.testcontext.TestContext;
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
    public SearchSteps(TestContext context) {
        this.context =context;
    }

//    public SearchPage searchPage;
//
//
//    private WebDriver driver;



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

    @Before
    public void setupDriver() throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
//        String host = "localhost";
//        DesiredCapabilities dc;


//        if(System.getProperty("BROWSER") != null &&
//                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
//            dc = DesiredCapabilities.firefox();
//        }else{
//            dc = DesiredCapabilities.chrome();
//        }
//
//        if(System.getProperty("HUB_HOST") != null){
//            host = System.getProperty("HUB_HOST");
//        }
//
//        String completeUrl = "http://" + host + ":4444/wd/hub";
//        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @After
    public void quitDriver(){
        context.getDriver().quit();
    }

    @Given("^I am on the open browser and open google$")
    public void iAmOnTheOpenBrowserAndOpenGoogle() {

        context.getSearchPage().goToGoogle();
    }

    @When("Then I search for {string} on google page")
    public void thenISearchForOnGooglePage(String arg0) {
        context.getSearchPage().doGoogleSearch(arg0);
    }
}