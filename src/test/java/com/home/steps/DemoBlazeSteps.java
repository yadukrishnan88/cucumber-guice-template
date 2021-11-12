package com.home.steps;

import com.google.inject.Inject;
import com.home.baseutils.World;
import com.home.pages.DemoBlazeHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DemoBlazeSteps {

    private World world;

    @Inject
    public DemoBlazeSteps(World world) {
        this.world = world;
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
    }

    @Then("I should see {string} {string} message")
    public void iShouldSeeMessage(String text, String userName) {
        String welcomeText = demoBlazeHomePage.getWelcomeText();
        String expectedText = text + " " + userName;
        Assert.assertTrue(expectedText.trim().equalsIgnoreCase(welcomeText), "Welcome Label Mismatches");
    }

    @And("the page title should be {string}")
    public void thePageTitleShouldBe(String pageTitle) {
        Assert.assertEquals(demoBlazeHomePage.getPageTitle(), pageTitle);
    }
}
