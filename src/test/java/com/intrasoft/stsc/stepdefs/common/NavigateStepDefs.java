package com.intrasoft.stsc.stepdefs.common;

import com.intrasoft.stsc.pages.navigation.Navigate;
import cucumber.api.java.en.When;

public class NavigateStepDefs {

    Navigate navigate = new Navigate();

    @When("^the user navigates to \"([^\"]*)\" page$")
    public void theUserNavigatesTo(String pageName) {
        navigate.to(pageName);
    }

}
