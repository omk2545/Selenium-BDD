package com.context.testcontext;

import com.searchmodule.pages.GoogleSearchPage;
import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class TestContext {
//    public SearchPage getSearchPage() {
//        return searchPage;
//    }
//
//    public void setSearchPage(SearchPage searchPage) {
//        this.searchPage = searchPage;
//    }
    private WebDriver driver;
    private SearchPage searchPage;
    private GoogleSearchPage googleSearchPage;


    public SearchPage getSearchPage() {
        return searchPage;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        return googleSearchPage;
    }

    public void initPages(WebDriver driver){
        searchPage = new SearchPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
    }



}
