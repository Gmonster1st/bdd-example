package com.intrasoft.stsc.pages.contacts.contact_list;

import com.intrasoft.stsc.BaseTest;

public class ContactList extends BaseTest {

    public ContactListValidations validate;

    public ContactList() {
        validate = new ContactListValidations(this);
    }

    public ContactList filter(String filterValue) {
        waitForLoad();
        element.input(ContactListElements.GLOBAL_FILTER, filterValue);
        waitForLoad();
        return this;
    }

    public ContactList details() {
        waitForLoad();
        element.click(ContactListElements.DETAILS_LINK);
        waitForLoad();
        return this;
    }

}
