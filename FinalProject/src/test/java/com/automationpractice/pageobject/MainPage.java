package com.automationpractice.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {
    SelenideElement womenButton = $(By.xpath("//a[text()='Women']"));

    SelenideElement dressesButton = $(By.xpath("//div/ul/li/a[text()='Dresses']"));
    SelenideElement womenButtonMenu = $(By.xpath("//a[text()='Women']/following-sibling::*"));
    SelenideElement dressesButtonMenu = $(By.xpath("//div/ul/li/a[text() = 'Dresses']/following-sibling::*"));
    SelenideElement searchField = $(By.id("search_query_top"));
    SelenideElement searchButton = $(By.name("submit_search"));
    SelenideElement shoppingCartButton = $("div.shopping_cart>a");
    SelenideElement firstProductInPage = $("ul#homefeatured>li>div");
    SelenideElement addToCartButton = $("p.buttons_bottom_block>button.exclusive");
    SelenideElement singInButton = $(By.className("login"));

    private MainPage searchProduct(String query) {
        searchField.setValue(query);
        searchButton.click();
        return this;
    }

    public LoginPage goToLoginPage() {
        singInButton.click();
        return new LoginPage();
    }

    public boolean womenButtonMenuIsDisplayed() {
        womenButton.hover();
        return womenButtonMenu.isDisplayed();
    }

    public boolean dressesButtonMenuIsDisplayed() {
        dressesButton.hover();
        return dressesButtonMenu.isDisplayed();
    }

    public boolean searchAndNotFoundProduct(String query) {
        searchProduct(query);
        return $(By.className("alert-warning")).should(exist).exists();
    }

    public boolean searchAndFoundAnyProduct(String query) {
        searchProduct(query);
        return $("ul.product_list>li").should(exist).exists();
    }

    public boolean summerDressUrlSame() {
        String url1, url2;
        womenButton.hover();
        $(By.xpath("//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]")).click();
        url1 = url();
        womenButton.click();
        $("div.block_content>ul.tree>li.last>a").click();
        $(By.xpath("//div[@class='block_content']//ul//a[contains(text(),'Summer Dresses')]")).click();
//        .should(exist)
        url2 = url();
        return url1.equals(url2);
    }
    public int addAllDressesToCart() {
        womenButton.click();
        $("div.block_content>ul.tree>li.last>a").click();
        $(By.xpath("//div[@class='block_content']//ul//a[contains(text(),'Summer Dresses')]")).click();

        ElementsCollection allProducts = $$("ul.product_list>li>div>div.right-block");
        for(SelenideElement element : allProducts) {
            element.hover();
            element.$(byText("Add to cart")).click();
            $("div.clearfix>div.layer_cart_cart>div.button-container>span>span").click();
        }
        return allProducts.size();
    }
    public ShoppingCartPage goToShoppingCartPage() {
        shoppingCartButton.click();
        return new ShoppingCartPage();
    }

    public MainPage addFirstProductInCartWithSetQuantity(String value) {
        firstProductInPage.click();
        $("#quantity_wanted").clear();
        $("#quantity_wanted").setValue(value);
        addToCartButton.click();
        if($("a.fancybox-item").should(visible).isDisplayed()) {
            $("a.fancybox-item").click();
        }
        else {
            $("span.continue>span").click();
        }
        return this;
    }
}
