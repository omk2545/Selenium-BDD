package com.test.stepdefs;

import com.context.testcontext.TestContext;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    TestContext context;
    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        context.setDriver(driver);
        context.initPages(driver);
    }

    @After
    public void tearDown(Scenario s){

        if (s.isFailed()) try {
//            byte[] screenshot =
//                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            s.attach(screenshot,"png","image");
            System.out.println("Scenario failed....");
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
        context.getDriver().quit();
    }

    @BeforeStep
    public void updateExtent(){
        System.out.println("@@@@@@@");
//        sc.getText();
//        System.out.println(sc.getText());



    }
}
