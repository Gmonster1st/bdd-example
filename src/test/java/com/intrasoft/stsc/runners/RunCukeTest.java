package com.intrasoft.stsc.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        monochrome = false,
        plugin = {"json:target/cucumber.json", "pretty",
                "html:target/cucumber-html-report", "junit:target/cucumber-junit-report.xml"},
        features = {"src/test/resources/features/"},
        tags = {"@UI and not @Manual"},
        glue = {"com.intrasoft.stsc.stepdefs"})
public class RunCukeTest {

    @BeforeClass
    public static void setup() { System.out.println(">>>>>>>>>>>>>> BEFORE ALL <<<<<<<<<<<<<"); }

    @AfterClass
    public static void teardown() {
        System.out.println(">>>>>>>>>>>>>> AFTER ALL <<<<<<<<<<<<<");
    }

}
