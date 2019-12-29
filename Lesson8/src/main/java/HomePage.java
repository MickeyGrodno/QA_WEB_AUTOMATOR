import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

//    @FindBy(xpath = "//a [@href='#collapseOne']")
    @FindBy(xpath = "(//h4 [@class = 'panel-title'])[1]")
    WebElement menuEShop;
    @FindBy(xpath = "//span [text() = 'Coupons']")

    WebElement menuCoupons;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CouponsPage goToCouponsPage() {
        menuEShop.click();
        menuCoupons.click();
        return new CouponsPage(driver);
    }
}
