package com.qawa.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends DataFixture{
    @BeforeEach
    public void configuration() {
        loginPage.checkAndLoginWithUserData(email, password, loginPageUrl);
    }
    @Test
    public void logoutTest() {
        userPanel.logOut();
        assertEquals(loginPageUrl, url());
    }

}
