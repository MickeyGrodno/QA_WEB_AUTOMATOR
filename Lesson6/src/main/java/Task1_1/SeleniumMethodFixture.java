package Task1_1;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethodFixture {

  protected WebDriver driver;

  @Rule
  public ExternalResource driverRule = new ExternalResource() {
    @Override
    protected void before() {
      System.out.println("Starting a browser");
      System.setProperty("webdriver.chrome.driver", "E:\\QA_WEB_AUTOMATOR\\Lesson 6\\task6JUnit4Pro_HW_version\\task6JUnit4Pro\\driver\\chromedriver.exe");
      driver = new ChromeDriver();
    }

    @Override
    protected void after(){
      System.out.println("Stopping the browser");
      if (driver != null) {
        driver.quit();
      }
    }
  };
}
