import org.junit.Test;

public class LoginTest extends ChromeFixture {
    private LoginPage loginPage;
    private String email = "demo@open-eshop.com";
    private String password = "demo";
    @Test
    public void LoginWithUserDataTest() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(email, password);
    }
}
