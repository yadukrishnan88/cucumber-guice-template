package com.home.baseutils;


import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class World {
    public WebDriver driver;

    public World() {
        this.driver = new DriverFactory().getWebDriver();
    }
}
