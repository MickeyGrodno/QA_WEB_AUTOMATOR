package com.qawa.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchAndDeleteCouponTest extends DataFixture{
    @BeforeEach
    public void configuration() {
        loginPage.checkAndLoginWithUserData(email, password, loginPageUrl);
        userPanel.goToCouponsPage().goToCreateCouponPage().createNewCoupon(couponName,validDate, numberOfCoupons);
    }
    @Test
    public void searchAndDeleteCoupon() {
        couponsPage.searchAndDeleteCoupon(couponName);
        couponsPage.searchCoupon(couponName);
        assertTrue(couponsPage.getSearchTableIsEmpty());
    }
}
