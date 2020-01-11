import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DataFixture {
    protected static WebDriver driver;
    protected String email = "demo@open-eshop.com";
    protected String password = "demo";
    protected String couponName = "GESCoupon";
    protected String validDate = "20200101";
    protected int numberOfCoupons = 1;
    protected String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";

    protected HomePage checkAndLogin() {
        if (driver.getCurrentUrl().equals(loginPageUrl)) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginWithUserData(email,password);
        }
        return new HomePage(driver);
    }

    @Rule
    public ExternalResource driverRule = new ExternalResource() {
        @Override
        protected void before() {
            System.out.println("Starting a browser");
            System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(loginPageUrl);
        }

        @Override
        protected void after() {
            System.out.println("Stopping the browser");
            if (driver != null) {
                driver.quit();
            }
        }
    };
}
