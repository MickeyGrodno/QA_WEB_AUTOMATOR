package com.qawa.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPanel {
    private WebDriver driver;
    private Logger log = Logger.getLogger(UserPanel.class);
    @FindBy(xpath = "//span[@class='caret']")
    private WebElement userMenuButton;
    @FindBy(xpath = "//a [@href = 'http://open-eshop.stqa.ru/oc-panel/auth/logout']")
    private WebElement logoutButton;

    public UserPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage logOut() {
        try {
            userMenuButton.click();
            logoutButton.click();
        } catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return new LoginPage(driver);
    }
}
