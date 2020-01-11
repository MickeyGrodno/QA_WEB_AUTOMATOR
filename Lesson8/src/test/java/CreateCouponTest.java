import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateCouponTest extends DataFixture {
    private CouponsPage couponsPage;

    @Before
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

    @After
    public void deleteCoupon() throws InterruptedException {
        couponsPage.deleteCoupon();
    }
}
