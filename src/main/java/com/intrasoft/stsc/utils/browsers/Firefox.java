package com.intrasoft.stsc.utils.browsers;

import com.intrasoft.stsc.utils.config.ResourcesConfig;
import com.intrasoft.stsc.utils.config.SysConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Firefox {

    public static WebDriver start() {
        if (SysConfig.getRemoteURL().equalsIgnoreCase("true")) {
            try {
                return new RemoteWebDriver(new URL(SysConfig.getRemoteURL()), getFirefoxOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return new FirefoxDriver(getFirefoxOptions());
        }
    }

    private static FirefoxOptions getFirefoxOptions() {
        System.setProperty("browser", "firefox");
        System.setProperty("webdriver.gecko.driver", ResourcesConfig.getFirefoxDriver());
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(getFirefoxProfile());
        if (SysConfig.getHeadlessMode()) {
            options.setHeadless(true);
        }
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        String binaryVersion = System.getProperty("webdriver.firefox.binary.version");
        return options;
    }

    private static FirefoxProfile getFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", ResourcesConfig.getOutputDir());
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip," +
                "text/csv," +
                "text/plain," +
                "image/jpeg," +
                "application/octet-stream," +
                "application/xml,text/xml," +
                "application/pdf," +
                "application/x-pdf," +
                "application/vnd.ms-excel," +
                "application/msword," +
                "application/vnd.ms-powerpoint," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet," +
                "application/vnd.openxmlformats-officedocument.presentationml.presentation," +
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
        );
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("plugin.disable_full_page_plugin_for_types",
                "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
        return profile;
    }

}
