import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends ChromeFixture {
    private UserPanel userPanel;
    private LoginPage loginPage;
    private String email = "demo@open-eshop.com";
    private String password = "demo";

    @Before
    public void configuration() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(email, password);
    }

    @Test
    public void searchAndDeleteCouponTest() {
        userPanel = new UserPanel(driver);
        userPanel.logOut();
    }
}
