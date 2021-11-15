package com.home.pages;

import com.google.inject.Inject;
import com.home.baseutils.AbstractPage;
import com.home.baseutils.DriverFactory;
import com.home.baseutils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeHomePage extends AbstractPage {
    private final String demoBlazeUrl = "https://www.demoblaze.com/";

    /*@Inject
    private DriverFactory driverFactory;*/

    @Inject
    public DemoBlazeHomePage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @FindBy(id = "navbarExample")
    private WebElement topNavigationBar;

    @FindBy(css = "#logInModal > div > div")
    private WebElement loginModal;

    By loginLnk = By.id("login2");
    By userId = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginBtn = By.cssSelector("button.btn.btn-primary");
    By welcomeLabel = By.id("nameofuser");

    public void visitDemoBlaze() {
        driver.get(demoBlazeUrl);
        Log.info("Navigated to " + demoBlazeUrl);
    }

    public DemoBlazeHomePage clickOnLoginLink() {
        findElementInSection(topNavigationBar, loginLnk).click();
        return this;
    }

    public DemoBlazeHomePage inputUserName(String userName) {
        findElementInSection(loginModal, userId).sendKeys(userName);
        return this;
    }

    public DemoBlazeHomePage inputPassword(String loginPassword) {
        findElementInSection(loginModal, password).sendKeys(loginPassword);
        return this;
    }

    public DemoBlazeHomePage clickLoginBtn() {
        findElementInSection(loginModal, loginBtn).click();
        return this;
    }

    public String getWelcomeText() {
        waitForVisibilityOfElement(driver.findElement(welcomeLabel));
        return findElementInSection(topNavigationBar, welcomeLabel).getText();
    }
}
