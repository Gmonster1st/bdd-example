package com.intrasoft.stsc.stepdefs.common;

import com.intrasoft.stsc.pages.navigation.Navigate;
import cucumber.api.java.en.Given;

public class HomeStepDefs {

    Navigate navigate = new Navigate();

    @Given("^the Demo Application is opened$")
    public void applicationOpens() {
        navigate.openApp();
    }

}
