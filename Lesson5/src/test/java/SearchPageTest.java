import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageTest {
    private SearchPage searchPage;
    private WebDriver driver;

    @Before
    public void config() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/search");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void isTheUserPresentTest() {
        Boolean userPresent = searchPage.isTheUserPresent("MickeyGrodno");
        Assert.assertTrue(userPresent);
    }

    @Test
    public void userNotFoundTest() {
        searchPage.searchUsers("UserNotFound7814");
        String actualNotFoundMessage = searchPage.getCouldNotFoundMessage();
        String expectedMessage = "We couldn’t find any users matching 'UserNotFound7814'";
        Assert.assertEquals(expectedMessage, actualNotFoundMessage);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
