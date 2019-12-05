import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TaskActions {
    public static void main(String[] args) {
        WebDriver driver;
        String page = "http://en.wikipedia.org";

        System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(page);

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));

        Actions actions = new Actions(driver);

        actions.sendKeys(searchInput, "test text")
                .keyDown(Keys.CONTROL).sendKeys("a")
                .sendKeys("x")
                .sendKeys("v")
                .keyUp(Keys.CONTROL).sendKeys(Keys.ENTER)
                .build().perform();

        driver.quit();
    }
}
