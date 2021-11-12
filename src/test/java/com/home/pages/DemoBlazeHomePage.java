package com.home.pages;

import com.google.inject.Inject;
import com.home.baseutils.AbstractPage;
import com.home.baseutils.World;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeHomePage extends AbstractPage {
    private final String demoBlazeUrl = "https://www.demoblaze.com/";

    @Inject
    private World world;

    @Inject
    public DemoBlazeHomePage(World world) {
        super(world);
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

    /*@FindBy(id = "login2")
    private WebElement loginLnk;

    @FindBy(id = "loginusername")
    private WebElement userId;

    @FindBy(id = "loginpassword")
    private WebElement password;*/

    public void visitDemoBlaze() {
        driver.get(demoBlazeUrl);
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(loginModal));
        return findElementInSection(topNavigationBar, welcomeLabel).getText();
    }
}
