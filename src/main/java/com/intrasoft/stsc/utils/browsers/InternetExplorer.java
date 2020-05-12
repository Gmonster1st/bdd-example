package com.intrasoft.stsc.utils.browsers;

import com.intrasoft.stsc.utils.config.ResourcesConfig;
import com.intrasoft.stsc.utils.config.SysConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class InternetExplorer {

    public static WebDriver start() {
        if (SysConfig.getRemoteURL().equalsIgnoreCase("true")) {
            try {
                return new RemoteWebDriver(
                        new URL(SysConfig.getRemoteURL()), getInternetExplorerOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return new InternetExplorerDriver(getInternetExplorerOptions());
        }
    }

    private static InternetExplorerOptions getInternetExplorerOptions() {
        System.setProperty("browser", "ie");
        System.setProperty("webdriver.ie.driver", ResourcesConfig.getInternetExplorerDriver());
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("requireWindowFocus", true);
        options.setCapability("enablePersistentHover", false);
        options.setCapability("ignoreProtectedModeSettings", false);
        options.setCapability("browser.download.dir", ResourcesConfig.getOutputDir());
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        return options;
    }
}



