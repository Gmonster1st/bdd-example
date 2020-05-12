package com.intrasoft.stsc.stepdefs.contacts;

import com.intrasoft.stsc.pages.contacts.contact.Contact;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class ContactStepDefs {

    Contact contact = new Contact();

    @And("^the user adds a new contact with \"([^\"]*)\" data$")
    public void addContact(String dataType, DataTable testData) {
        contact.addContact(testData);
    }

    @Then("^the selected contact contains appropriate data$")
    public void theSelectedContactContainsAppropriateData(DataTable testData) {
        contact.validate.verifyView(testData);
    }

    @And("^the user updates the data of the selected contact$")
    public void theUserUpdatesTheDataOfTheSelectedContact(DataTable testData) {
        contact.updateContact(testData);
    }

    @Then("^the data of the selected contact are updated appropriately$")
    public void theDataOfTheSelectedContactAreUpdatedAppropriately(DataTable testData) {
        contact.validate.verifyView(testData);
    }
}
