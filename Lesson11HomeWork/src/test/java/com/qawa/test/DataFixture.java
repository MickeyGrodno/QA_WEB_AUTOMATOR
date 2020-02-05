package com.qawa.test;

import com.codeborne.selenide.Configuration;
import com.qawa.pageobjects.LoginPage;
import com.qawa.pageobjects.ProductPage;
import com.qawa.pageobjects.UserPanel;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class DataFixture {


    protected String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";
    protected String email = "demo@open-eshop.com";
    protected String password = "demo";
    protected int price = 20;
    protected String currency = "USD";
    protected String title = "GESpro3";
    protected String newProductUrl = "http://open-eshop.stqa.ru/cat/"+title.toLowerCase()+".html";
    protected String description = "description text";
    protected int priceOffer = 5;
    protected int offerValid = 20200220;
    protected int licenses = 2;
    protected int licenseDays = 50;
    protected int supportDays = 100;
    protected int version = 1;
    protected int featureProduct = 20200210;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected UserPanel userPanel;


    @BeforeEach
    public void config(){
        Configuration.holdBrowserOpen = true;
        open(loginPageUrl);
    }

}
