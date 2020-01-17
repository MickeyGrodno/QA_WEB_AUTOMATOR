package com.qawa.tests;

import com.qawa.pageobjects.HomePage;
import com.qawa.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import listeners.WebDriverListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class DataFixture {
    protected static WebDriver driver;
    protected String email = "demo@open-eshop.com";
    protected String password = "demo";
    protected String couponName = "GEScoupon";
    protected String validDate = "20200101";
    protected int numberOfCoupons = 10;
    protected String loginPageUrl = "http://open-eshop.stqa.ru/oc-panel/auth/login";

    protected HomePage checkAndLogin() {
        if (driver.getCurrentUrl().equals(loginPageUrl)) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginWithUserData(email,password);
        }
        return new HomePage(driver);
    }

//    @BeforeSuite
//    protected void beforeSuite() {
//        BasicConfigurator.configure();
//    }

    @BeforeMethod
    protected void beforeMethod() {
        System.out.println("Starting a browser");

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

    @AfterMethod
    protected void afterMethod() {
        System.out.println("Stopping the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
