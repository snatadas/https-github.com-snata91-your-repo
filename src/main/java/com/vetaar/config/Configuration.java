package com.vetaar.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static final String CONFIG_FILE_PATH = "config.properties";

    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getAppiumServerUrl() {
        return properties.getProperty("appium.server.url");
    }

    public static String getPlatformName() {
        return properties.getProperty("platform.name");
    }

    public static String getDeviceName() {
        return properties.getProperty("device.name");
    }

    public static String getAppPackage() {
        return properties.getProperty("app.package");
    }

    public static String getAppActivity() {
        return properties.getProperty("app.activity");
    }

    public static String getAutomationName() {
        return properties.getProperty("automation.name");
    }
}



