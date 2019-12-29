import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateCouponTest extends ChromeFixture {
    private CouponsPage couponsPage;
    private LoginPage loginPage;
    private String email = "demo@open-eshop.com";
    private String password = "demo";
    private String couponName = "GESCoupon";
    private String validDate = "20200101";
    private int numberOfCoupons = 1;

    @Before
    public void configuration() {
        loginPage = new LoginPage(driver);
        couponsPage = loginPage.loginWithUserData(email, password).goToCouponsPage();
    }

    @Test
    public void createNewCouponTest() {
        couponsPage.createNewCoupon(couponName, validDate, numberOfCoupons);
    }

    @After
    public void deleteCoupon() throws InterruptedException {
        couponsPage.deleteCoupon(couponName);
    }
}
