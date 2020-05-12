package com.intrasoft.stsc.pages.contacts.contact;

import com.intrasoft.stsc.BaseTest;
import com.intrasoft.stsc.utils.config.TestDataConfig;
import io.cucumber.datatable.DataTable;

public class Contact extends BaseTest {

    public ContactValidations validate;

    public Contact() {
        validate = new ContactValidations(this);
    }

    TestDataConfig testDataConfig = new TestDataConfig();

    public void addContact(DataTable testData) {
        inputData(testData);
        element.click(ContactElements.SAVE_BUTTON);
    }

    public void updateContact(DataTable testData) {
        inputData(testData);
        element.click(ContactElements.UPDATE_BUTTON);
    }

    public void edit() {
        waitForLoad();
        element.click(ContactElements.EDIT_BUTTON);
    }

    public void delete() {
        element.click(ContactElements.DELETE_BUTTON);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        waitForLoad();
        element.click(ContactElements.BACK_BUTTON);
    }

    private void inputData(DataTable testData) {
        element.input(ContactElements.NAME, testDataConfig.getValue(testData, "Name"));
        element.input(ContactElements.ADDRESS, testDataConfig.getValue(testData, "Address"));
        element.dropdown(ContactElements.CITY, testDataConfig.getValue(testData, "City"));
        element.input(ContactElements.PHONE, testDataConfig.getValue(testData, "Phone"));
        element.input(ContactElements.EMAIL, testDataConfig.getValue(testData, "Email"));
        element.checkbox("Disabled", testDataConfig.getValue(testData, "Status"));
        element.radiobutton(testDataConfig.getValue(testData, "Gender"));
    }

}
