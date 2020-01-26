package com.qawa.tests;

import com.qawa.pageobjects.CouponsPage;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCouponTest extends DataFixture {
    private CouponsPage couponsPage;

    @BeforeMethod
    public void configuration() {
        couponsPage = checkAndLogin().goToCouponsPage();
    }

    @Test
    public void createNewCouponTest() {
        couponsPage.createNewCoupon(couponName, validDate, numberOfCoupons);
        Assert.assertTrue(couponsPage.getSearchTableHasNewCoupon(couponName));
    }

    @Test
    public void createNewCouponSuccessIsPresentTest() {
        couponsPage.createNewCoupon(couponName, validDate, numberOfCoupons);
        Assert.assertEquals("Success", couponsPage.getCouponCreatedMessage());
    }

    @AfterMethod
    public void deleteCoupon() throws InterruptedException {
        if(couponsPage.getSearchTableHasNewCoupon(couponName)) {
            couponsPage.deleteCoupon();
        }
    }
}
