package com.intrasoft.stsc;


import com.intrasoft.stsc.utils.browsers.Chrome;
import com.intrasoft.stsc.utils.browsers.Edge;
import com.intrasoft.stsc.utils.browsers.Firefox;
import com.intrasoft.stsc.utils.browsers.InternetExplorer;
import com.intrasoft.stsc.utils.common.Elements;
import com.intrasoft.stsc.utils.config.SysConfig;
import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTest {

    public static WebDriver driver;
    public static Wait wait;
    public static Elements element;

    public void openBrowser() {
        int timeout = Integer.parseInt(SysConfig.getTimeout());
        switch (SysConfig.getBrowser()) {
            case "chrome": {
                driver = Chrome.start();
                break;
            }
            case "firefox": {
                driver = Firefox.start();
                break;
            }
            case "edge": {
                driver = Edge.start();
                break;
            }
            case "ie": {
                driver = InternetExplorer.start();
                break;
            }
        }
        assert driver != null;
        wait = new WebDriverWait(driver, timeout);
        element = new Elements();
    }

    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) try {
            File screenshot =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                scenario.embed(Files.readAllBytes(screenshot.toPath()), "image/png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }

        driver.quit();
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> expectation =
                driver -> {
                    assert driver != null;
                    return ((JavascriptExecutor) driver)
                            .executeScript("return document.readyState").toString().equals("complete");
                };
        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

}
