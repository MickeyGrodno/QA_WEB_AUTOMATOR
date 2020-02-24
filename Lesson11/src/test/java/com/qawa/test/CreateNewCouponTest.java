package com.qawa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewCouponTest extends DataFixture{
    @BeforeEach
    public void configuration() {
        loginPage.checkAndLoginWithUserData(email,password,loginPageUrl);
    }
    @Test
    public void createNewCouponTest() {
        createCouponPage = userPanel.goToCouponsPage().goToCreateCouponPage();
        couponsPage = createCouponPage.createNewCoupon(couponName,validDate,numberOfCoupons);
        assertTrue(couponsPage.getSearchTableHasNewCoupon(couponName));
    }
    @AfterEach
    public void deleteCoupon(){
        couponsPage.searchAndDeleteCoupon(couponName);
    }
}
