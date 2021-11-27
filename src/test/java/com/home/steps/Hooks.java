package com.home.steps;

import com.google.inject.Inject;
import com.home.baseutils.DriverFactory;
import com.home.baseutils.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    Scenario scenario;

    @Inject
    private DriverFactory driverFactory;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        Log.info("Starting execution of the scenario: " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        this.scenario = scenario;
        if (scenario.getStatus().toString().equalsIgnoreCase("passed")) {
            Log.info(scenario.getName() + " -- " + scenario.getStatus());
        } else if (scenario.getStatus().toString().equalsIgnoreCase("failed")) {
            Log.error(scenario.getName() + " -- " + scenario.getStatus());
        } else
            Log.debug(scenario.getName() + " -- SKIPPED");
        driverFactory.driver.quit();
    }
}
