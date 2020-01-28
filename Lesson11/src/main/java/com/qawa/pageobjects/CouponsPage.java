package com.qawa.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CouponsPage {
    private SelenideElement newCouponButton = $(By.xpath("//a[@class='btn btn-primary pull-right']"));
    private SelenideElement searchField = $(By.xpath("//input [@placeholder = 'Coupon name']"));
    private SelenideElement searchButton = $(By.xpath("//button [text() = 'Search']"));
    private SelenideElement deleteCouponButton = $(By.xpath("//a[@class='btn btn-danger index-delete']"));
    private SelenideElement confirmDeleteButton = $(By.xpath("//div[@class='sweet-alert showSweetAlert visible']" +
            "//button[@class='confirm']"));
    private ElementsCollection allSearchTableLines = $$(By.xpath("//table[@class='table table-striped table-bordered']//tbody/tr"));
    private SelenideElement couponCreatedMessage = $(By.cssSelector("h4.alert-heading"));


    public CreateCouponPage goToCreateCouponPage() {
        newCouponButton.click();
        return new CreateCouponPage();
    }

    public CouponsPage searchCoupon(String couponsName) {
        searchField.setValue(couponsName);
        searchButton.click();
        return this;
    }

    public CouponsPage searchAndDeleteCoupon(String couponsName) {
        searchCoupon(couponsName);
        deleteCouponButton.click();
        confirmDeleteButton.click();
        return this;
    }

    public String getCouponCreatedMessage(){
        return couponCreatedMessage.getText();
    }

    public boolean getSearchTableIsEmpty() {
        boolean tableIsEmpty;
        tableIsEmpty = allSearchTableLines.isEmpty();
        return tableIsEmpty;
    }

    public boolean getSearchTableHasNewCoupon(String couponName) {
        boolean tableHasNewCoupon;
        searchCoupon(couponName);
        tableHasNewCoupon = !allSearchTableLines.isEmpty();
        return tableHasNewCoupon;
    }
}
