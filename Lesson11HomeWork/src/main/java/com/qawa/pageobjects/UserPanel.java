package com.qawa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPanel {
    private SelenideElement eShopButton = $(By.xpath("//div[@id='accordion']//span[text()='eShop']"));
    private SelenideElement productsButton = $(By.xpath("//a[@title='Products']"));

    public UserPanel() {
    }

    public ProductPage goToProductsPage() {
        eShopButton.click();
        productsButton.click();
        return new ProductPage();
    }

}
