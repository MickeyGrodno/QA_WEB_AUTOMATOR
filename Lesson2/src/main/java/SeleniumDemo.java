import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:/QA_WEB_AUTOMATOR/Lesson 2/Project L1/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        List<WebElement> webElements;
        final String request = "Selenium";
        String firstPageTitle;
        String secondPageTitle;
        String parentHandle;

        try {
            driver.get("https://selenium.dev/");
            WebElement queryInput = driver.findElement(By.id("gsc-i-id1"));
            queryInput.sendKeys(request + "\n");
            webElements = driver.findElements(By.partialLinkText("Selenium"));

            if (!webElements.isEmpty()) {
                System.out.println("Most popular links with request \"" + request + "\" :");
                for (WebElement element : webElements) {
                    System.out.println(element.getText());
                }
                System.out.println();
            }

            parentHandle = driver.getWindowHandle();
            firstPageTitle = driver.getTitle();
            driver.findElement(By.linkText(webElements.get(1).getText())).click();

            for (String childHandle : driver.getWindowHandles()) {
                if (!childHandle.equals(parentHandle)) {
                    driver.switchTo().window(childHandle);
                }
            }
            secondPageTitle = driver.getTitle();

            System.out.println("First page title - " + firstPageTitle + ";");
            System.out.println("Second page title - " + secondPageTitle + ".");
        } finally {
            driver.quit();
        }
    }
}
