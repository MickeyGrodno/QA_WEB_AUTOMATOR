package com.qawa.tests;

import com.qawa.pageobjects.CouponsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class CreateCouponTest extends DataFixture {
    private CouponsPage couponsPage;

    @BeforeEach
    public void configuration() {
        couponsPage = checkAndLogin().goToCouponsPage();
    }

    @Test
    public void createNewCouponTest() {
        couponsPage.createNewCoupon(couponName, validDate, numberOfCoupons);
        assertTrue(couponsPage.getSearchTableHasNewCoupon(couponName));
    }

    @Test
    public void createNewCouponSuccessIsPresentTest() {
        couponsPage.createNewCoupon(couponName, validDate, numberOfCoupons);
        assertEquals("Success", couponsPage.getCouponCreatedMessage());
    }

    @AfterEach
    public void deleteCoupon() throws InterruptedException {
        if(couponsPage.getSearchTableHasNewCoupon(couponName)) {
            couponsPage.deleteCoupon();
        }
    }
}
