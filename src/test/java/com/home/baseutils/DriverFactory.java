package com.home.baseutils;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class DriverFactory {
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public WebDriver driver;

    public DriverFactory() {
        BrowserFactory browser = new BrowserFactory();
        setWebDriver(browser.createBrowserInstance());
        this.driver = getWebDriver();
    }

    private WebDriver getWebDriver() {
        return webDriver.get();
    }

    private void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
