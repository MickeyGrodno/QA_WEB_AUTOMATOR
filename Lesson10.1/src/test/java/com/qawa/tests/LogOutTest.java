package com.qawa.tests;

import com.qawa.pageobjects.UserPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class LogOutTest extends DataFixture {
    private UserPanel userPanel;

    @BeforeEach
    public void configuration() {
        checkAndLogin();
    }

    @Test
    public void logOutTest() {
        userPanel = new UserPanel(driver);
        userPanel.logOut();
        assertEquals(loginPageUrl, driver.getCurrentUrl());
    }
}
