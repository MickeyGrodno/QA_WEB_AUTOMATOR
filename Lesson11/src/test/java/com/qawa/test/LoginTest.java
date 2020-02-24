package com.qawa.test;

import com.qawa.pageobjects.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginTest extends DataFixture{
    private LoginPage loginPage;
    private String email = "demo@open-eshop.com";
    private String password = "demo";

    @Test
    public void loginTest() {
        loginPage = new LoginPage();
        loginPage.loginWithUserData(email,password);
        assertNotEquals(loginPageUrl, url());
    }
}
