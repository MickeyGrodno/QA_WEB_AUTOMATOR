package com.qawa.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.qawa.pageobjects.CouponsPage;
import com.qawa.pageobjects.CreateCouponPage;
import com.qawa.pageobjects.LoginPage;
import com.qawa.pageobjects.UserPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class DataFixture {
    protected String email = "demo@open-eshop.com";
    protected String password = "demo";
    protected String couponName = "GEScoupon";
    protected String validDate = "20200101";
    protected int numberOfCoupons = 10;
    protected String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";
    protected LoginPage loginPage = new LoginPage();
    protected UserPanel userPanel = new UserPanel();
    protected CouponsPage couponsPage = new CouponsPage();
    protected CreateCouponPage createCouponPage = new CreateCouponPage();

    @BeforeEach
    public void config(){
        Configuration.headless= true;

        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        open(loginPageUrl);
    }

    @AfterEach
    public void after(){
        WebDriverRunner.closeWindow();
    }
}
