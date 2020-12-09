package com.searchmodule.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToGoogle(){
        this.driver.get("https://www.google.com/");
    }

}
