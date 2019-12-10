import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopicPage {
    private WebDriver driver;
    private By loadMoreButton = By.xpath("//* [text() = 'Load more…']");
    private By wordPressStarButton = By.xpath("//a [@href='/topics/wordpress']/following-sibling::a " +
            "[@class='btn btn-sm d-flex flex-items-center']");
    private By loadAllFeaturedTopics = By.xpath("//* [@class='py-4 border-bottom']");

    public TopicPage(WebDriver driver) {
        this.driver = driver;
    }

    public TopicPage submitLoadMoreButton() {
        driver.findElement(loadMoreButton).submit();
        return this;
    }

    public int getNumberOfFeaturedTopics() {
        return driver.findElements(loadAllFeaturedTopics).size();
    }

    public LoginPage pressWordPressStarButton(){
        driver.findElement(wordPressStarButton).click();
        return new LoginPage(driver);
    }




}
