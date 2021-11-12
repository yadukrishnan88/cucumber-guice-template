package com.home.baseutils;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private World world;
    public WebDriver driver;
    private static final int WAIT_TIME = 10;

    @Inject
    public AbstractPage(World world) {
        this.driver = world.driver;
        PageFactory.initElements(world.driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement findElementInSection(WebElement sectionElement, By childElement) {
        return sectionElement.findElement(childElement);
    }

}
