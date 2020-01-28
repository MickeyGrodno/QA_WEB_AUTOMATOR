package com.qawa.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateCouponPage {
    private SelenideElement coponNameField = $(By.id("name"));
    private SelenideElement coponValidateDateField = $(By.name("valid_date"));
    private SelenideElement numberOfCouponsField = $(By.name("number_coupons"));
    private SelenideElement sumbitButton = $(By.name("submit"));

    public CreateCouponPage() {
    }

    public CouponsPage createNewCoupon(String couponName, String validateDate, int numberOfCoupons) {
        coponNameField.setValue(couponName);
        coponValidateDateField.setValue(validateDate);
        numberOfCouponsField.clear();
        numberOfCouponsField.setValue(String.valueOf(numberOfCoupons));
        sumbitButton.click();
        return new CouponsPage();
    }
}
