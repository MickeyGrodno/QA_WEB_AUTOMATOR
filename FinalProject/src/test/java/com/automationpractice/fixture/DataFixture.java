package com.automationpractice.fixture;

import com.automationpractice.pageobject.LoginPage;
import com.automationpractice.pageobject.MainPage;
import com.automationpractice.pageobject.MyAccountPage;
import com.automationpractice.pageobject.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class DataFixture {
    protected String correctEmail = "Sergei199@list.ru";
    protected String correctPassword = "11111";
    protected String startPageUrl = "http://automationpractice.com/index.php";
    protected String myAccountPageUrl = "http://automationpractice.com/index.php?controller=my-account";
    protected LoginPage loginPage = new LoginPage();
    protected MainPage mainPage = new MainPage();
    protected MyAccountPage myAccountPage = new MyAccountPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @BeforeEach
    public void beforeTest(){
        Configuration.holdBrowserOpen = true;
        open(startPageUrl);
    }

    @AfterEach
    public void afterTest(){

//        WebDriverRunner.closeWindow();
    }
}
