import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TaskTable {
    public static void main(String[] args) {

        WebDriver driver;
        WebElement element;
        Table table;
        String page = "https://www.w3schools.com/html/html_tables.asp";

        System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Projects\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(page);
        element = driver.findElement(By.id("customers"));
        table = new Table(element);

        table.getAllTitles();
        table.getNumberOfLines();
        table.getCurrentCell(2, 3);
        table.getCurrentCell(4, "Company");
        table.getCurrentCell(1, "Country");
        table.getCurrentCell(2, "Contact");

        driver.quit();
    }
}
