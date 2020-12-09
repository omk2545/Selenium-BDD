package com.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestDemo {
    private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
    private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";


    public static void main(String[] args) {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);

        ExtentTest feature = extent.createTest(Feature.class, "Refund item");
        ExtentTest scenario = feature.createNode(Scenario.class, "Jeff returns a faulty microwave");
        scenario.createNode(Given.class, "Jeff has bought a microwave for $100").pass("pass");
        scenario.createNode(And.class, "he has a receipt").pass("pass");
        scenario.createNode(When.class, "he returns the microwave").pass("pass");
        scenario.createNode(Then.class, "Jeff should be refunded $100").fail("fail");


//        extent.createTest("ScreenCapture")
//                .addScreenCaptureFromPath("extent.png")
//                .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
//
//        extent.createTest("LogLevels")
//                .info("info")
//                .pass("pass")
//                .warning("warn")
//                .skip("skip")
//                .fail("fail");
//
//        extent.createTest("CodeBlock").generateLog(
//                Status.PASS,
//                MarkupHelper.createCodeBlock(CODE1, CODE2));
//
//        extent.createTest("ParentWithChild")
//                .createNode("Child")
//                .pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");
//
//        extent.createTest("Tags")
//                .assignCategory("MyTag")
//                .pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");
//
//        extent.createTest("Authors")
//                .assignAuthor("TheAuthor")
//                .pass("This test 'Authors' was assigned by a special kind of author tag.");
//
//        extent.createTest("Devices")
//                .assignDevice("TheDevice")
//                .pass("This test 'Devices' was assigned by a special kind of devices tag.");

    extent.flush();
    }

}

