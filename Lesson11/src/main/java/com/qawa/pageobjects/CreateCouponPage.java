package com.qawa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateCouponPage {
    private SelenideElement couponNameField = $(By.id("name"));
    private SelenideElement couponValidateDateField = $(By.name("valid_date"));
    private SelenideElement numberOfCouponsField = $(By.name("number_coupons"));
    private SelenideElement submitButton = $(By.name("submit"));

    public CreateCouponPage() {
    }

    public CouponsPage createNewCoupon(String couponName, String validateDate, int numberOfCoupons) {
        couponNameField.setValue(couponName);
        couponValidateDateField.setValue(validateDate);
        numberOfCouponsField.clear();
        numberOfCouponsField.setValue(String.valueOf(numberOfCoupons));
        submitButton.click();
        return new CouponsPage();
    }
}
