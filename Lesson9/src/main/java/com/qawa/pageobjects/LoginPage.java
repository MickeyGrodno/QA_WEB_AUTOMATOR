package com.qawa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
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
        emailField.sendKeys(login);
        return this;
    }

    private LoginPage setPassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }

    private void clickToLoginButton() {
        loginButton.submit();
    }

    public HomePage loginWithUserData(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickToLoginButton();
        return new HomePage(driver);
    }
}
