package com.qawa.tests;

import com.qawa.pageobjects.CouponsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class SearchAndDeleteCouponTest extends DataFixture {
    private CouponsPage couponsPage;

    @BeforeEach
    public void configuration() {
        couponsPage = checkAndLogin()
                .goToCouponsPage()
                .createNewCoupon(couponName, validDate, numberOfCoupons);
    }

    @Test
    public void searchedCouponIsOneTest() {
        assertEquals(1, couponsPage.searchCoupon(couponName).getSearchTableSize());

    }

    @Test
    public void searchQueryIsPresentTest() {
        assertEquals(couponName, couponsPage.searchCoupon(couponName).getSearchFieldText());
    }

    @Test
    public void searchAndDeleteCouponTest() throws InterruptedException {
        couponsPage.searchCoupon(couponName);
        couponsPage.deleteCoupon();
        assertTrue(couponsPage.searchCoupon(couponName).getSearchTableIsEmpty());
    }

    @Test
    public void deletedCouponNotDisplayedTest() throws InterruptedException {
        couponsPage.searchCoupon(couponName).deleteCoupon();
        assertTrue(couponsPage.getCouponIsDeleted());
    }

    @AfterEach
    public void delCoupon() throws InterruptedException {
        if (couponsPage.getSearchTableHasNewCoupon(couponName) && !couponsPage.getCouponIsDeleted()) {
            couponsPage.deleteCoupon();
        }
    }
}
