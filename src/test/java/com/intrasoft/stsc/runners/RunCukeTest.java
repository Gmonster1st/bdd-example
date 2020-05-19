package com.intrasoft.stsc.runners;

import com.intrasoft.stsc.utils.config.EnvDataConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

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
    public static void setup() {
        System.out.println(">>>>>>>>>>>>>> BEFORE ALL <<<<<<<<<<<<<");
        RestAssured.baseURI = EnvDataConfig.getAPIURL();
        given().when().delete("contacts/delete").then().assertThat().statusCode(200);
    }

    @AfterClass
    public static void teardown() {
        System.out.println(">>>>>>>>>>>>>> AFTER ALL <<<<<<<<<<<<<");
    }

}
