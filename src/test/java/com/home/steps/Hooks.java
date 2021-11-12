package com.home.steps;

import com.google.inject.Inject;
import com.home.baseutils.World;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Inject
    private World world;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        world.driver.quit();
    }
}
