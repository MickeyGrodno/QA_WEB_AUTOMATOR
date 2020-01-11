import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends DataFixture {
    private LoginPage loginPage;
    private String invalidEmail = "invalid@mail.ru";
    private String invalidPassword = "invalid";
    private String homePageUrl = "http://open-eshop.stqa.ru/oc-panel";

    @Test
    public void LoginWithUserDataTest() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(email, password);
        Assert.assertEquals(homePageUrl, driver.getCurrentUrl());
    }

    @Test
    public void LoginWithInvalidUserData() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithUserData(invalidEmail, invalidPassword);
        Assert.assertEquals(loginPageUrl, driver.getCurrentUrl());
    }
}
