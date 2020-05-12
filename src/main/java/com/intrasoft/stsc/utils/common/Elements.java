package com.intrasoft.stsc.utils.common;

import com.intrasoft.stsc.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Elements extends BaseTest {

    public void click(By by) {
        WebElement buttonOrLink = driver.findElement(by);
        buttonOrLink.click();
    }

    public void input(By by, String value) {
        WebElement input = driver.findElement(by);
        if (value != null && !value.isEmpty()) {
            input.clear();
            input.sendKeys(value);
        }
    }

    public void dropdown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        if (value != null && !value.isEmpty()) {
            dropdown.click();
            element.click(By.xpath("//li[contains(@class,'ui-dropdown-item') and contains(.,'" + value + "')]"));
        }
    }

    public void checkbox(String checkboxLabel, String value) {
        if (value != null && !value.isEmpty()) {
            WebElement chbox;
            if (value.equalsIgnoreCase("enabled")) {
                chbox = driver.findElement(By.xpath("//label[text()='"
                        + checkboxLabel + "']/preceding-sibling::input[@type='checkbox']"));
                if (chbox.isSelected()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
                }
            } else {
                chbox = driver.findElement(By.xpath("//label[text()='"
                        + checkboxLabel + "']/preceding-sibling::input[@type='checkbox']"));
                if (!chbox.isSelected()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chbox);
                }
            }
        }
    }

    public void radiobutton(String value) {
        if (value != null && !value.isEmpty()) {
            if (value.equalsIgnoreCase("female")) {
                if (isElementPresent(
                        By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-state-active')]"))) {
                    driver.findElement(
                            By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-radiobutton-box')]")).click();
                }
            } else {
                if (isElementPresent(
                        By.xpath("//p-radiobutton[@value='f']//*[contains(@class,'ui-state-active')]"))) {
                    driver.findElement(
                            By.xpath("//p-radiobutton[@value='m']//*[contains(@class,'ui-radiobutton-box')]")).click();
                }
            }
        }
    }

    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0)
            return true;
        else
            return false;
    }

}
