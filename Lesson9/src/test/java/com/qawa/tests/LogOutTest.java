package com.qawa.tests;

import com.qawa.pageobjects.UserPanel;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends DataFixture {
    private UserPanel userPanel;

    @BeforeMethod
    public void configuration() {
        checkAndLogin();
    }

    @Test
    public void logOutTest() {
        userPanel = new UserPanel(driver);
        userPanel.logOut();
        Assert.assertEquals(loginPageUrl, driver.getCurrentUrl());
    }
}
