import org.junit.Before;
import org.junit.Test;

public class SearchAndDeleteCouponTest extends ChromeFixture {
    private CouponsPage couponsPage;
    private LoginPage loginPage;
    private String email = "demo@open-eshop.com";
    private String password = "demo";
    private String couponName = "GESCoupon";

    @Before
    public void configuration() {
        loginPage = new LoginPage(driver);
        couponsPage = loginPage.loginWithUserData(email, password).goToCouponsPage();
    }

    @Test
    public void searchAndDeleteCouponTest() throws InterruptedException {
        couponsPage.deleteCoupon(couponName);
    }
}
