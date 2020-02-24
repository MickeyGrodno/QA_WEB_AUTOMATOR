import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.grid.selenium.GridLauncher;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GridTest {
    private String pageUrl = "http://www.energo.grodno.by/";
    private String test1Url = "http://www.energo.grodno.by/content/organizacionnaya-struktura-rup-grodnoenergo";
    private String test2Url = "http://www.energo.grodno.by/content/rukovodstvo-rup-grodnoenergo";
    private String test3Url = "http://www.energo.grodno.by/content/strategiya-razvitiya";
    private String test4Url = "http://www.energo.grodno.by/content/politika-rup-grodnoenergo-v-oblasti-ohrany-truda";
    private String test5Url = "http://www.energo.grodno.by/content/svedeniya-ob-imeyushchihsya-v-rup-grodnoenergo-patentah-licenziyah-i-sertifikatah";
    private String test6Url = "http://energo.grodno.by/content/plan-komissii-po-protivodeystviyu-korrupcii-na-2019-god";
    private String test7text = "Краткая справка по истории развития энергетики на Гродненщине";
    private String test8url = "http://www.energo.grodno.by/";
    private String test9Url = "http://www.energo.grodno.by/content/%D1%82%D0%B0%D1%80%D0%B8%D1%84%D1%8B-0";
    private String test10url = "http://www.energo.grodno.by/search/node/%D0%93%D0%AD%D0%A1";

    private SelenideElement aboutButton = $(By.cssSelector("li.menu-320"));
    private SelenideElement structureButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Структура']"));
    private SelenideElement executiveButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Руководство']"));
    private SelenideElement strategyButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Стратегия развития']"));
    private SelenideElement politicsButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Политика РУП \"Гродноэнерго\" в области охраны труда']"));
    private SelenideElement patentsButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Патенты, лицензии, аттестаты, сертификаты']"));
    private SelenideElement commissionButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='Комиссия по противодействию коррупции']"));
    private SelenideElement historyButton = $(By.xpath("//ul[@id='nice-menu-0']//a[text()='История предприятия']"));
    private SelenideElement historyOfDevelopmentElement = $(By.xpath("//h1[@class='title']"));
    private SelenideElement logoImage = $(By.className("logourltop"));
    private SelenideElement rateButton = $(By.xpath("//li//a[text()='Тарифы']"));
    private SelenideElement searchField = $(By.xpath("//input[@id='edit-search-block-form-1']"));
    private SelenideElement searchButton = $(By.id("edit-submit"));

    @BeforeClass
    public static void beforeClassSetUp() throws Exception {
//        GridHubConfiguration conf = new GridHubConfiguration();
//        conf.loadDefault();
//        Hub hub = new Hub(conf);
//        hub.start();

        String[] a = {"-port", "4444",
                "-host", "localhost",
                "-role", "hub",
                "-servlets", "com.seleniumgrid2api.servlet.AllProxiesJsonServlet,com.seleniumgrid2api.servlet.ProxyStatusJsonServlet" };
        GridLauncher.main(a);
        }

    @Before
    public void setUp() {
        Configuration.browser = CHROME;
//        Configuration.holdBrowserOpen = true;
        Configuration.headless = true;
        Configuration.remote = "http://192.168.100.4:4444/wd/hub";
    }

    @Test
    public void test1() {
        open(pageUrl);
        aboutButton.click();
        structureButton.click();
        assertEquals(test1Url, url());
    }

    @Test
    public void test2() {
        open(pageUrl);
        aboutButton.click();
        executiveButton.click();
        assertEquals(test2Url, url());
    }
    @Test
    public void test3() {
        open(pageUrl);
        aboutButton.click();
        strategyButton.click();
        assertEquals(test3Url, url());
    }
    @Test
    public void test4() {
        open(pageUrl);
        aboutButton.click();
        politicsButton.click();
        assertEquals(test4Url, url());
    }
    @Test
    public void test5() {
        open(pageUrl);
        aboutButton.click();
        patentsButton.click();
        assertEquals(test5Url, url());
    }
    @Test
    public void test6() {
        open(pageUrl);
        aboutButton.click();
        commissionButton.click();
        assertEquals(test6Url, url());
    }
    @Test
    public void test7() {
        open(pageUrl);
        aboutButton.click();
        historyButton.click();
        assertEquals(test7text, historyOfDevelopmentElement.getText());
    }
    @Test
    public void test8() {
        open(pageUrl);
        logoImage.click();
        assertEquals(test8url, url());
    }
    @Test
    public void test9() {
        open(pageUrl);
        rateButton.click();
        assertEquals(test9Url, url());
    }
    @Test
    public void test10() {
        open(pageUrl);
        searchField.click();
        searchField.sendKeys("ГЭС");
        searchButton.click();
        assertEquals(test10url, url());
    }
}
