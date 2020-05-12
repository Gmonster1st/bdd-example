package com.intrasoft.stsc.pages.contacts.contact_list;

import org.openqa.selenium.By;

public class ContactListElements {

    public static final By CONTACT_LIST_PAGE_TITLE = By.xpath("//h3[contains(.,'Contact List')]");

    public static final By GLOBAL_FILTER = By.xpath("//input[@placeholder='Global Filter']");
    public static final By DETAILS_LINK = By.xpath("//a[text()='Details']");

}
