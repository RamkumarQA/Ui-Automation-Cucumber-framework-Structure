package com.afw.Web_Driver_Manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.afw.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static WebDriver driver;
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(Constants.CONFIG_PROPERTIES_PATH);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = properties.getProperty("BROWSER");
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            // Add more browsers if needed
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getAppUrl() {
        return properties.getProperty("APP_URL");
    }

    public static String getUserName() {
        return properties.getProperty("UserName");
    }

    public static String getPassword() {
        return properties.getProperty("Password");
    }
}