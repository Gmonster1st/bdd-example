package com.intrasoft.stsc.utils.browsers;

import com.intrasoft.stsc.utils.config.ResourcesConfig;
import com.intrasoft.stsc.utils.config.SysConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Edge  {

    public static WebDriver start() {
        if (SysConfig.getRemoteURL().equalsIgnoreCase("true")) {
            try {
                return new RemoteWebDriver(
                        new URL(SysConfig.getRemoteURL()), getEdgeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return new EdgeDriver(getEdgeOptions());
        }
    }

    private static EdgeOptions getEdgeOptions() {
        System.setProperty("browser", "edge");
        System.setProperty("webdriver.edge.driver", ResourcesConfig.getEdgeDriver());
        EdgeOptions options = new EdgeOptions();
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //options.setCapability("download.default_directory", Resources.getOutputDir());
        options.setCapability("browser.download.dir", ResourcesConfig.getOutputDir());
        options.setCapability("requireWindowFocus", true);
        options.setCapability("enablePersistentHover", false);
        options.setCapability("ignoreProtectedModeSettings", true);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability("chrome.switches", Arrays.asList("--incognito"));
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability("requireWindowFocus", true);
        options.setCapability("enablePersistentHover", false);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        return options;
    }

}
