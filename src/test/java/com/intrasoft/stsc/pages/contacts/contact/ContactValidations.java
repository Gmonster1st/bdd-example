package com.intrasoft.stsc.pages.contacts.contact;

import com.intrasoft.stsc.BaseTest;
import com.intrasoft.stsc.utils.config.TestDataConfig;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

public class ContactValidations extends BaseTest {

    private final Contact pageInstance;

    ContactValidations(Contact instance) {
        pageInstance = instance;
    }

    TestDataConfig testDataConfig = new TestDataConfig();

    public void verifyView(DataTable testData) {
        waitForLoad();
        Assert.assertEquals(testDataConfig.getValue(testData, "Name"),
                getElement(ContactElements.NAME_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "Address"),
                getElement(ContactElements.ADDRESS_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "City"),
                getElement(ContactElements.CITY_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "Phone"),
                getElement(ContactElements.PHONE_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "Email"),
                getElement(ContactElements.EMAIL_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "Status"),
                getElement(ContactElements.STATUS_VALUE).getText());
        Assert.assertEquals(testDataConfig.getValue(testData, "Gender"),
                getElement(ContactElements.GENDER_VALUE).getText().toLowerCase());
    }

    public void verifyContactPageOpens() {
        waitForLoad();
        Assert.assertTrue(element.isElementPresent(ContactElements.CONTACT_PAGE_TITLE));
    }

}
