
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;


public class GoogleTest {
    public static void main(String[] args) {
        final String page = "https://www.google.com/";
        WebElement element;
        ArrayList<WebElement> webElements;
        String pictureStyle;

        System.setProperty("webdriver.chrome.driver",
                "E:/QA_WEB_AUTOMATOR/Projects/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(page);

        element = driver.findElement(By.xpath("//input [@class = 'gLFyf gsfi' and @title='Поиск']"));
        element.sendKeys("Test with selenium\n");

        driver.findElement(By.xpath("//a [@class = 'q qs' and text() = 'Картинки']")).click();
        driver.findElement(By.id("hdtb-tls")).click();

        webElements = (ArrayList<WebElement>) driver.findElements(By.className("hdtb-mn-hd"));
        Optional<WebElement> filterByLable = webElements.stream().
                filter(elem -> {String lable = elem.getAttribute("aria-label");
                return  lable != null && lable.equals("Тип");
                }).findFirst();

        if (!filterByLable.isPresent()) {
            throw new NoSuchElementException("Element not found!");
        }

        filterByLable.get().click();

        driver.findElement(By.xpath("//div [@class = 'hdtb-mn-hd' and @aria-label = 'Тип']")).click();
        driver.findElement(By.cssSelector(".hdtb-mn-hd[aria-label='Тип']")).click();
        driver.findElement(By.xpath("//* [@class = 'q qs' and text() = 'Клип-арт']")).click();

        element = driver.findElement((By.xpath("//div/a/img")));
        element.click();

        pictureStyle = element.getAttribute("style");

        System.out.println(pictureStyle);

//        driver.quit();
    }
}
