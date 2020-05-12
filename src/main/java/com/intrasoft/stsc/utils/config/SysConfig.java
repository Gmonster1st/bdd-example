package com.intrasoft.stsc.utils.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static com.intrasoft.stsc.utils.config.ResourcesConfig.getAbsolutePath;

public class SysConfig {

    public static String getEnvironment() {
        return getProperty("environment");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getRemoteURL() {
        return getProperty("driver.remote.url");
    }

    public static String getTimeout() {
        return getProperty("timeout");
    }

    public static Boolean getHeadlessMode() {
        return Boolean.parseBoolean(getProperty("headless.mode"));
    }

    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return SysConfig.getPomProperty(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPomProperty(String propertyName) {
        String property = "";
        try {
            File file = new File(getAbsolutePath() + "/pom.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("properties");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    property = eElement.getElementsByTagName(propertyName).item(0).getTextContent();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return property;
    }
}
