package com.qawa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPanel {
    private SelenideElement eShopButton = $(By.xpath("//div[@id='accordion']//span[text()='eShop']"));
    private SelenideElement couponsButton = $(By.xpath("//span [text() = 'Coupons']"));
    private SelenideElement userMenuButton = $(By.xpath("//span[@class='caret']"));
    private SelenideElement logoutButton = $(By.xpath("//a[@href='http://open-eshop.stqa.ru/oc-panel/auth/logout']"));

    public UserPanel() {
    }

    public CouponsPage goToCouponsPage() {
        eShopButton.click();
        couponsButton.click();
        return new CouponsPage();
    }

    public LoginPage logOut() {
        userMenuButton.click();
        logoutButton.click();
        return new LoginPage();
    }
}
