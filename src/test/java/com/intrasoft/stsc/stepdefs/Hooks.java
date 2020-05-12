package com.intrasoft.stsc.stepdefs;

import com.intrasoft.stsc.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest {

    @Before
    public void beforeTest() {
        openBrowser();
    }

    @After
    public void afterTest(Scenario scenario) {
        closeBrowser(scenario);
    }

}
