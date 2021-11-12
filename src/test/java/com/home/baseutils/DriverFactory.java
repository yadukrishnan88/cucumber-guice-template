package com.home.baseutils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public DriverFactory() {
        BrowserFactory browser = new BrowserFactory();
        setWebDriver(browser.createBrowserInstance());
    }

    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
