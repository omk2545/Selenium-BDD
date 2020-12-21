package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {
        "pretty",
        "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun-reports/rerun.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
//        "progress",
//        "summary",
        "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt"
        },
//        tags = "",
        publish = true,

        glue={"com.test.stepdefs"},
features = {"src/test/resources/features"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }


}
