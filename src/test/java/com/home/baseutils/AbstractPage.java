package com.home.baseutils;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private DriverFactory driverFactory;
    public WebDriver driver;
    private static final long WAIT_TIME = 15;
    protected WebDriverWait wait;

    @Inject
    public AbstractPage(DriverFactory driverFactory) {
        this.driver = driverFactory.driver;
        wait = new WebDriverWait(driver, WAIT_TIME);
        PageFactory.initElements(driverFactory.driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement findElementInSection(WebElement sectionElement, By childElement) {
        return sectionElement.findElement(childElement);
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.visibilityOf(refreshWebElementReference(element)));
        }
    }

    public WebElement refreshWebElementReference(WebElement element) {
        String elementInfo = element.toString();
        elementInfo = elementInfo.substring(elementInfo.indexOf("->"));
        String elementLocator = elementInfo.substring(elementInfo.indexOf(": "));
        elementLocator = elementLocator.substring(2, elementLocator.length() - 1);
        WebElement refreshedWebElement = null;
        if (elementInfo.contains("-> link text:")) {
            refreshedWebElement = driver.findElement(By.linkText(elementLocator));
        } else if (elementInfo.contains("-> name:")) {
            refreshedWebElement = driver.findElement(By.name(elementLocator));
        } else if (elementInfo.contains("-> id:")) {
            refreshedWebElement = driver.findElement(By.id(elementLocator));
        } else if (elementInfo.contains("-> xpath:")) {
            refreshedWebElement = driver.findElement(By.xpath(elementLocator));
        } else if (elementInfo.contains("-> class name:")) {
            refreshedWebElement = driver.findElement(By.className(elementLocator));
        } else if (elementInfo.contains("-> css selector:")) {
            refreshedWebElement = driver.findElement(By.cssSelector(elementLocator));
        } else if (elementInfo.contains("-> partial link text:")) {
            refreshedWebElement = driver.findElement(By.partialLinkText(elementLocator));
        } else if (elementInfo.contains("-> tag name:")) {
            refreshedWebElement = driver.findElement(By.tagName(elementLocator));
        } else {
            System.out.println("No valid locator found. Couldn't refresh element");
        }
        return refreshedWebElement;
    }

}
