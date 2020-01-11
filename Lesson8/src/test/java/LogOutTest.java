import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends DataFixture {
    private UserPanel userPanel;

    @Before
    public void configuration() {
        checkAndLogin();
    }

    @Test
    public void logOutTest() {
        userPanel = new UserPanel(driver);
        userPanel.logOut();
        Assert.assertEquals(loginPageUrl, driver.getCurrentUrl());
    }
}
