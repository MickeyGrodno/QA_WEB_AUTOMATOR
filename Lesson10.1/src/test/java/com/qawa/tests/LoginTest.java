package com.qawa.tests;

import com.qawa.pageobjects.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends DataFixture {
    private LoginPage loginPage;
    private String invalidEmail = "invalid@mail.ru";
    private String invalidPassword = "invalid";
    private String homePageUrl = "http://open-eshop.stqa.ru/oc-pane";

    @Test
    public void LoginWithUserDataTest() {

        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(email, password);
        assertEquals(homePageUrl, driver.getCurrentUrl());
    }

    @Test
    public void LoginWithInvalidUserData() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(invalidEmail, invalidPassword);
        assertEquals(loginPageUrl, driver.getCurrentUrl());
    }
}
