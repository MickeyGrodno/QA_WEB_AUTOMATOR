package Task1_3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

public class LoginFixture extends BrowserFixture {

  @BeforeClass
  public static void login() {
    System.out.println("Login");
    driver.get("http://localhost/someApplication");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
  }

  @AfterClass
  public static void logout() {
    System.out.println("Logout");
    driver.findElement(By.name("logout")).click();
  }

}
