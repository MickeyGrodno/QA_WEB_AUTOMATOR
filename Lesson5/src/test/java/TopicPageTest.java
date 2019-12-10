import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TopicPageTest {
    private static TopicPage topicPage;
    private static WebDriver driver;
    int countOfTopicsBefore, countOfTopicsAfter;

    @Before
    public void config() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/topics");
        topicPage = new TopicPage(driver);

    }

    @Test
    public void SubmitLoadMoreButtonTest() throws InterruptedException {
        countOfTopicsBefore = topicPage.getNumberOfFeaturedTopics();
        topicPage.submitLoadMoreButton();
        TimeUnit.SECONDS.sleep(2);
        countOfTopicsAfter = topicPage.getNumberOfFeaturedTopics();
        Assert.assertTrue(countOfTopicsAfter>countOfTopicsBefore);
    }

    @Test
    public void PressWordPressStarButtonTest() {
        topicPage.submitLoadMoreButton();
        LoginPage loginPage = topicPage.pressWordPressStarButton();
        String headingText = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", headingText);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
