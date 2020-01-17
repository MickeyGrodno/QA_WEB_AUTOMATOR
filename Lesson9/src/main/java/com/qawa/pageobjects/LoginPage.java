package com.qawa.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private Logger log = Logger.getLogger(LoginPage.class);
    private String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";
    @FindBy(xpath = "//section[@id='page']//input[@placeholder='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//section[@id='page']//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "(//i [@class='glyphicon glyphicon-user glyphicon']/parent::*)[2]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private LoginPage setEmail (String login) {
        try {
        emailField.sendKeys(login);
        log.info("Sending keys to field Email: " + login);
    } catch (
    NoSuchElementException e) {
        log.fatal("WebElement not found");
    }
        return this;
    }

    private LoginPage setPassword (String password) {
        try {
            passwordField.sendKeys(password);
            log.info("Sending keys to field Password: " + password);
        }
        catch (
                NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return this;
    }

    private void clickToLoginButton() {
        try {
            loginButton.submit();
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
    }

    public HomePage loginWithUserData(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickToLoginButton();
        return new HomePage(driver);
    }
}
