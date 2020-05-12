package com.intrasoft.stsc.pages.contacts.contact;

import org.openqa.selenium.By;

public class ContactElements {

    public static final By CONTACT_PAGE_TITLE = By.xpath("//h3[contains(.,'Add New Contact')]");

    public static final By NAME = By.name("name");
    public static final By ADDRESS = By.name("address");
    public static final By CITY = By.name("city");
    public static final By PHONE = By.name("phone");
    public static final By EMAIL = By.name("email");

    public static final By SAVE_BUTTON = By.xpath("//button[contains(text(),'Save')]");
    public static final By DELETE_BUTTON = By.xpath("//button[contains(.,'Delete')]");
    public static final By BACK_BUTTON = By.xpath("//a[text()='Back']");
    public static final By EDIT_BUTTON = By.xpath("//a[text()='Edit']");
    public static final By UPDATE_BUTTON = By.xpath("//button[contains(text(),'Update')]");

    public static final By NAME_VALUE = By.xpath("//h3");
    public static final By ADDRESS_VALUE = By.xpath("(//dt[text()='Address']/following-sibling::dd)[1]");
    public static final By CITY_VALUE = By.xpath("(//dt[text()='City']/following-sibling::dd)[1]");
    public static final By PHONE_VALUE = By.xpath("(//dt[text()='Phone']/following-sibling::dd)[1]");
    public static final By EMAIL_VALUE = By.xpath("(//dt[text()='Email']/following-sibling::dd)[1]");
    public static final By STATUS_VALUE = By.xpath("(//dt[text()='Status']/following-sibling::dd)[1]");
    public static final By GENDER_VALUE = By.xpath("(//dt[text()='Gender']/following-sibling::dd)[1]");

}
