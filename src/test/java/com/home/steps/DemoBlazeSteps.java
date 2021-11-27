package com.home.steps;

import com.google.inject.Inject;
import com.home.baseutils.DriverFactory;
import com.home.baseutils.Log;
import com.home.pages.DemoBlazeHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoBlazeSteps {

    private DriverFactory driverFactory;

    @Inject
    public DemoBlazeSteps(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Inject
    private DemoBlazeHomePage demoBlazeHomePage;

    @Given("I am on Demo Blaze home page")
    public void iAmOnDemoBlazeHomePage() {
        demoBlazeHomePage.visitDemoBlaze();
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String userName, String password) {
        demoBlazeHomePage.clickOnLoginLink().inputUserName(userName).inputPassword(password)
                .clickLoginBtn();
        Log.info("Successfully Logged in as " + userName);
    }

    @Then("I should see {string} {string} message")
    public void iShouldSeeMessage(String text, String userName) {
        String welcomeText = demoBlazeHomePage.getWelcomeText();
        String expectedText = text + " " + userName;
        assertThat(welcomeText).as("Welcome Label Mismatches").isEqualTo(expectedText);
        Log.info("Captured the welcome text \"" + welcomeText + "\" from the page");
    }

    @And("the page title should be {string}")
    public void thePageTitleShouldBe(String pageTitle) {
        assertThat(driverFactory.driver.getTitle()).as("Page Title Mismatches").isEqualTo(pageTitle);
        Log.info("Page title is: " + driverFactory.driver.getTitle());
    }
}
