package com.qawa.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private Logger log = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "(//h4 [@class = 'panel-title'])[1]")
    WebElement menuEShop;
    @FindBy(xpath = "//span [text() = 'Coupons']")
    WebElement menuCoupons;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CouponsPage goToCouponsPage() {
        try {
            menuEShop.click();
            menuCoupons.click();
        } catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return new CouponsPage(driver);
    }
}
