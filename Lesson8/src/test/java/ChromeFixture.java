import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeFixture {
    protected static WebDriver driver;
    @Rule
    public ExternalResource driverRule = new ExternalResource() {
        @Override
        protected void before() {
            System.out.println("Starting a browser");
            System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://open-eshop.stqa.ru/oc-panel/auth/login/");
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
