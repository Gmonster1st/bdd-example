package com.intrasoft.stsc.pages.contacts.contact_list;

import com.intrasoft.stsc.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ContactListValidations extends BaseTest {

    private final ContactList pageInstance;

    ContactListValidations(ContactList instance) {
        pageInstance = instance;
    }

    public void verifyContactExists(String filterValue) {
        Assert.assertTrue(element.isElementPresent(By.xpath("//table[contains(.,'" + filterValue + "')]")));
    }

    public void verifyContactNotExist(String filterValue) {
        Assert.assertFalse(element.isElementPresent(By.xpath("//table[contains(.,'" + filterValue + "')]")));
    }

    public void verifyContactListPageOpens() {
        waitForLoad();
        Assert.assertTrue(element.isElementPresent(ContactListElements.CONTACT_LIST_PAGE_TITLE));
    }
}
