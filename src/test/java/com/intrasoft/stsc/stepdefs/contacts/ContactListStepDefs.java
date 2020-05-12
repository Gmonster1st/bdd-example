package com.intrasoft.stsc.stepdefs.contacts;

import com.intrasoft.stsc.pages.contacts.contact.Contact;
import com.intrasoft.stsc.pages.contacts.contact_list.ContactList;
import com.intrasoft.stsc.pages.navigation.Navigate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ContactListStepDefs {

    Navigate navigate = new Navigate();
    Contact contact = new Contact();
    ContactList contactList = new ContactList();

    @Then("^a new Contact \"([^\"]*)\" is created successfully$")
    public void aNewContactWithIsCreatedSuccessfully(String filterValue) {
        contactList.filter(filterValue)
                .validate.verifyContactExists(filterValue);
    }

    @And("^the user selects the contact \"([^\"]*)\" to \"([^\"]*)\"$")
    public void theUserSelectsTheContactToView(String filterValue, String action) {
        contactList.filter(filterValue);
        contactList.details();
        switch (action) {
            case ("edit"): {
                contact.edit();
                break;
            }
            case ("delete"): {
                contact.delete();
                break;
            }
        }

    }

    @Then("^the contact \"([^\"]*)\" is deleted successfully$")
    public void theContactIsDeletedSuccessfully(String filterValue) {
        contactList.filter(filterValue)
                .validate.verifyContactNotExist(filterValue);
    }

    @Then("^the Contact \"([^\"]*)\" is not created successfully$")
    public void theContactIsNotCreatedSuccessfully(String filterValue) {
        navigate.toContactList()
                .validate.verifyContactListPageOpens();
        contactList.filter(filterValue)
                .validate.verifyContactNotExist(filterValue);
    }
}
