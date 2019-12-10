import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private By searchField = By.xpath("//input [@aria-label='Search GitHub']");
    private By searchButton = By.xpath("//button [text()='Search']");
    private By usersMenu = By.xpath("//a [text()='Users']");
    private By notFoundMessage = By.xpath("//div [@class='blankslate']/h3");
    private By userMenuIsActive = By.xpath("//a [@class='menu-item selected' and text()='Users']");

    SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private SearchPage typeSearchText(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    private SearchPage searchByText(String text){
        this.typeSearchText(text);
        driver.findElement(searchButton).click();
        return this;
    }

    private By foundCurrentUser(String text) {
        return By.xpath(String.format("//a [@href='/%s']", text));
    }

    SearchPage searchUsers(String text) {
        this.searchByText(text);
        driver.findElement(usersMenu).click();
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(userMenuIsActive));
        return this;
    }

    boolean isTheUserPresent(String text) {
        searchUsers(text);
        boolean isPresent = driver.findElements(foundCurrentUser(text)).size()>0;
        return isPresent;
    }
    String getCouldNotFoundMessage() {
        return driver.findElement(notFoundMessage).getText();
    }
}
