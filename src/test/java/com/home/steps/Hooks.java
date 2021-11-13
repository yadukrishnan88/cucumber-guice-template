package com.home.steps;

import com.google.inject.Inject;
import com.home.baseutils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Inject
    private DriverFactory driverFactory;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        driverFactory.driver.quit();
    }
}
