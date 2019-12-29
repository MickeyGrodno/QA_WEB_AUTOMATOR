import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPanel {
    private WebDriver driver;
    @FindBy(xpath = "//span[@class='caret']")
    private WebElement userMenuButton;
    @FindBy(xpath = "//a [@href = 'http://open-eshop.stqa.ru/oc-panel/auth/logout']")
    private WebElement logoutButton;

    public UserPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage logOut() {
        userMenuButton.click();
        logoutButton.click();
        return new LoginPage(driver);
    }
}
