package com.qawa.tests;

import com.qawa.pageobjects.CouponsPage;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchAndDeleteCouponTest extends DataFixture {
    private CouponsPage couponsPage;

    @BeforeMethod
    public void configuration() {
        couponsPage = checkAndLogin()
                .goToCouponsPage()
                .createNewCoupon(couponName, validDate, numberOfCoupons);
    }

    @Test
    public void searchedCouponIsOneTest() {
        Assert.assertEquals(1, couponsPage.searchCoupon(couponName).getSearchTableSize());

    }

    @Test
    public void searchQueryIsPresentTest() {
        Assert.assertEquals(couponName, couponsPage.searchCoupon(couponName).getSearchFieldText());
    }

    @Test
    public void searchAndDeleteCouponTest() throws InterruptedException {
        couponsPage.searchCoupon(couponName);
        couponsPage.deleteCoupon();
        Assert.assertTrue(couponsPage.searchCoupon(couponName).getSearchTableIsEmpty());
    }

    @Test
    public void deletedCouponNotDisplayedTest() throws InterruptedException {
        couponsPage.searchCoupon(couponName).deleteCoupon();
        Assert.assertTrue(couponsPage.getСouponIsDeleted());
    }

    @AfterMethod
    public void delCoupon() throws InterruptedException {
        if (couponsPage.getSearchTableHasNewCoupon(couponName) && !couponsPage.getСouponIsDeleted()) {
            couponsPage.deleteCoupon();
        }
    }
}
