package com.intrasoft.stsc.utils.config;

import java.io.File;
import java.nio.file.Paths;

public class ResourcesConfig {

    public static String getChromeDriver() {
        return getTestResourcesPath() + "/drivers/chromedriver.exe";
    }

    public static String getInternetExplorerDriver() {
        return getTestResourcesPath() + "/drivers/IEDriverServer.exe";
    }

    public static String getFirefoxDriver() {
        return getTestResourcesPath() + "/drivers/geckodriver.exe";
    }

    public static String getEdgeDriver() {
        return getTestResourcesPath() + "/drivers/msedgedriver.exe";
    }

    public static String getOutputDir() {
        return getTestResourcesPath() + "/test-data/outputDir";
    }

    public static String getInputDir() {
        return getTestResourcesPath() + "/test-data/inputDir";
    }

    public static String getEnvironmentProperties(String environment) {
        return getResourcesPath() + "/conf/" + environment + "/env.properties";
    }

    private static String getTestResourcesPath() {
        return getResourcesPath("test");
    }

    private static String getResourcesPath() {
        return getResourcesPath("main");
    }

    private static String getResourcesPath(String packageName) {
        String filePathString = getAbsolutePath() + "/src/" + packageName + "/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }

    public static String getAbsolutePath() {
        String absPath = Paths.get(".").toAbsolutePath().normalize().toString();
        return absPath.replace("\\", "/");
    }
}
