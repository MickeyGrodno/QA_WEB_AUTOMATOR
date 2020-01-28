package com.qawa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {
    private SelenideElement emailField = $(By.xpath("//section[@id='page']//input[@placeholder='Email']"));
    private SelenideElement passwordField = $(By.xpath("//section[@id='page']//input[@placeholder='Password']"));
    private SelenideElement loginButton = $(By.xpath("//section[@id='page']//div/button[@type='submit']"));

    public LoginPage() {
    }

    public UserPanel loginWithUserData(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
        return new UserPanel();
    }

    public UserPanel checkAndLoginWithUserData(String email, String password, String loginPageUrl) {
        if(url().equals(loginPageUrl)) {
            return this.loginWithUserData(email, password);
        }
        return new UserPanel();
    }
}