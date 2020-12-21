package com.test.stepdefs;

import com.context.testcontext.TestContext;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {
    TestContext context;
    Scenario scenario;
    WebDriver driver;
    Boolean runWithGrid = false;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario){
        this.scenario =scenario;
        if (runWithGrid) {
            String host = "localhost";
            DesiredCapabilities dc;
            dc = DesiredCapabilities.chrome();
            if (System.getProperty("HUB_HOST") != null) {
                host = System.getProperty("HUB_HOST");
            }
            String completeUrl = "http://" + host + ":4444/wd/hub";
            try {
                this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            context.setDriver(driver);
            context.initPages(driver);
            this.scenario = scenario;
            this.driver = context.getDriver();
        }else {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            context.setDriver(driver);
            context.initPages(driver);
        }
    }

    @After(order = 1)
    public void tearDown() {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) context.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.log("This scenario is failed");
                scenario.attach(screenshot, "image/png", "this.site");

            } catch (ClassCastException cce) {
                cce.printStackTrace();
                context.getDriver().quit();

            }
        }
        context.getDriver().quit();
    }
}
