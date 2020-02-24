package com.automationpractice.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {
    SelenideElement womenButton = $(By.xpath("//a[@class='sf-with-ul'][text()='Women']"));

    SelenideElement dressesButton = $(By.xpath("//ul [@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']" +
            "/li/a[text() = 'Dresses']"));
    SelenideElement womenButtonMenu = $(By.xpath("//a[@class='sf-with-ul'][text()='Women']/following-sibling::*"));
    SelenideElement dressesButtonMenu = $(By.xpath("//ul [@class = 'sf-menu clearfix menu-content sf-js-enabled " +
            "sf-arrows']/li/a[text() = 'Dresses']/following-sibling::*"));
    SelenideElement searchField = $(By.id("search_query_top"));
    SelenideElement searchButton = $(By.name("submit_search"));
    SelenideElement shoppingCartButton = $("div.shopping_cart>a");
    SelenideElement firstProductInPage = $("//ul [@id = 'homefeatured']//div [@class = 'product-container']");
    SelenideElement addToCartButton = $(By.xpath("//span [text()='Add to cart']"));

    private MainPage searchProduct(String query) {
        searchField.setValue(query);
        searchButton.click();
        return this;
    }

    public boolean womenButtonMenuIsDisplayed() {
        womenButton.hover();
        return womenButtonMenu.isDisplayed();
    }

    public boolean dressesButtonMenuIsDisplayed() {
        dressesButton.hover();
        return dressesButtonMenu.isDisplayed();
    }

    public boolean productNotFound(String query) {
        searchProduct(query);
        return $(By.className("alert alert-warning")).exists();
    }

    public boolean productFound(String query) {
        searchProduct(query);
        return $(By.xpath("//ul [@class='product_list grid row']/li")).exists();
    }

    public boolean summerDressUrlSame() {
        String url1, url2;
        womenButton.hover();
        $(By.xpath("//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]")).click();
        url1 = url();
        womenButton.click();
        $(By.xpath("div.block_content>ul.tree>li.last>a")).click();
        $(By.xpath("//div[@class='block_content']//ul//a[contains(text(),'Summer Dresses')]")).click();
        url2 = url();
        return url1.equals(url2);
    }
    public MainPage addAllDressesToCart() {
        $(By.xpath("div.block_content>ul.tree>li.last>a")).click();
        $(By.xpath("//div[@class='block_content']//ul//a[contains(text(),'Summer Dresses')]")).click();

        ElementsCollection allProducts = $$("ul.product_list>li");
        for(SelenideElement element : allProducts) {
            element.hover();
            addToCartButton.click();
            $("div.clearfix>div.layer_cart_cart>div.button-container>span>span").click();
        }
        return this;
    }
    public ShoppingCartPage goToShoppingCartPage() {
        shoppingCartButton.click();
        return new ShoppingCartPage();
    }
    public MainPage addProductsInCart(String value) {
        firstProductInPage.click();
        $("//input[@id='quantity_wanted']").clear();
        $("//input[@id='quantity_wanted']").setValue(value);
        addToCartButton.click();
        $("a.fancybox-item").click();
        return this;
    }
}
