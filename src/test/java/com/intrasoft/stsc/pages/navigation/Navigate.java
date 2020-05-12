package com.intrasoft.stsc.pages.navigation;

import com.intrasoft.stsc.BaseTest;
import com.intrasoft.stsc.pages.contacts.contact.Contact;
import com.intrasoft.stsc.pages.contacts.contact_list.ContactList;
import com.intrasoft.stsc.utils.config.EnvDataConfig;

public class Navigate extends BaseTest {

    public NavigateValidations validate;

    public Navigate() {
        validate = new NavigateValidations(this);
    }

    public void openApp() {
        driver.get(EnvDataConfig.getURL());
    }

    public void to(String option) {
        switch (option) {
            case "Add New Contact": {
                toAddNewContact();
                break;
            }
            case "Contact List": {
                toContactList();
                break;
            }
        }
    }

    public ContactList toContactList() {
        element.click(NavigateElements.CONTACT_LIST_BUTTON);
        return new ContactList();
    }

    public Contact toAddNewContact() {
        element.click(NavigateElements.ADD_NEW_CONTACT_BUTTON);
        return new Contact();
    }

}
