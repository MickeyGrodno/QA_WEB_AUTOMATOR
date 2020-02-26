package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends DataFixture {
    @Test
    public void loginWithCorrectData() {
        mainPage.goToLoginPage().loginWithCorrectData(correctEmail, correctPassword);
        assertEquals(myAccountPageUrl, url());
    }
    @Test
    public void loginWithIncorrectData() {
        assertTrue(mainPage.goToLoginPage().loginWithIncorrectData(correctEmail,"1"));
    }
}
