package com.qawa.tests;

import com.qawa.pageobjects.HomePage;
import com.qawa.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListenerJU5;
import listeners.WebDriverListener;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

@ExtendWith(Watcher.class)
public class DataFixture {
    protected static WebDriver driver;
    protected String email = "demo@open-eshop.com";
    protected String password = "demo";
    protected String couponName = "GEScoupon";
    protected String validDate = "20200101";
    protected int numberOfCoupons = 10;
    protected String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";
    Logger logger = Logger.getLogger(DataFixture.class);

    protected HomePage checkAndLogin() {
        if (driver.getCurrentUrl().equals(loginPageUrl)) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginWithUserData(email,password);
        }
        return new HomePage(driver);
    }

    @BeforeEach
    protected void beforeMethod() {
        TestListenerJU5 listenerJU5 = new TestListenerJU5();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listenerJU5);

        System.out.println("Starting a browser");
        logger.info("Starting a browser (Message in log)");

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());
        driver = eventFiringWebDriver;

        driver.get(loginPageUrl);
    }

    @AfterEach
    protected void afterMethod() {
        System.out.println("Stopping the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
