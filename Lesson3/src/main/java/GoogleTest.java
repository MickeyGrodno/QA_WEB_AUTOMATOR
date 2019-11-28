
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GoogleTest {
    public static void main(String[] args) {
        final String page = "https://www.google.com/";
        WebElement element;
        ArrayList<WebElement> webElements;
        List<WebElement> elementIsPresent;
        String pictureStyle;

        System.setProperty("webdriver.chrome.driver",
                "E:/QA_WEB_AUTOMATOR/Projects/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.geolocation", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get(page);

        element = driver.findElement(By.xpath("//input [@class = 'gLFyf gsfi' and @title='Поиск']"));
        element.sendKeys("Test with selenium\n");
        driver.findElement(By.xpath("//a [@class = 'q qs' and text() = 'Картинки']")).click();

        elementIsPresent = driver.findElements(By.id("hdtb-tls"));

        if (!elementIsPresent.isEmpty()) {

            elementIsPresent.get(0).click();

            webElements = (ArrayList<WebElement>) driver.findElements(By.className("hdtb-mn-hd"));
            Optional<WebElement> filterByLable = webElements.stream().
                    filter(elem -> {
                        String lable = elem.getAttribute("aria-label");
                        return lable != null && lable.equals("Тип");
                    }).findFirst();

            if (!filterByLable.isPresent()) {
                throw new NoSuchElementException("Element not found!");
            }

            filterByLable.get().click();

            driver.findElement(By.xpath("//div [@class = 'hdtb-mn-hd' and @aria-label = 'Тип']")).click();
            driver.findElement(By.cssSelector(".hdtb-mn-hd[aria-label='Тип']")).click();
            driver.findElement(By.xpath("//* [@class = 'q qs' and text() = 'Клип-арт']")).click();

            element = driver.findElement((By.xpath("//div/a/img [@id ='dO18pKSZLiyD_M:']")));
            element.click();

            pictureStyle = element.getAttribute("style");

            System.out.println(pictureStyle);
        } else {
            driver.findElement(By.xpath("//* [@class = 'PNyWAd ZXJQ7c' and text() = 'Инструменты']")).click();
            driver.findElement(By.xpath("//* [@jsname = 'wLFV5d' and text() = 'Тип']")).click();
            driver.findElement(By.xpath("//* [@class = 'igM9Le' and text() = 'Клип-арт']")).click();
            driver.findElement(By.xpath("//a/div/img [@alt = 'Картинки по запросу \"Test with selenium\"']")).click();
            element = driver.findElement(By.xpath("//img [@class = 'n3VNCb' and @jsname = 'HiaYvf']"));
            element.click();

            pictureStyle = element.getAttribute("style");
            System.out.println(pictureStyle);
        }
        driver.quit();
    }
}
