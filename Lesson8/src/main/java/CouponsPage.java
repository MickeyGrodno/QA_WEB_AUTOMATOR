import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CouponsPage {
    private WebDriver driver;
    @FindBy(css = "div.pull-left>a")
    private WebElement createNewCouponButton;
    @FindBy(id = "name")
    private WebElement couponNameField;
    @FindBy(name = "valid_date")
    private WebElement validDateField;
    @FindBy(id = "number_coupons")
    private WebElement numberOfCouponsField;
    @FindBy(name = "submit")
    private WebElement sumbitButton;
    @FindBy(xpath = "//input [@placeholder = 'Coupon name']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[7]/a[2]")
    private WebElement deleteCouponButton;
    @FindBy(className = "confirm")
    private WebElement confirmButton;
    @FindBy(xpath = "//button [text() = 'Search']")
    private WebElement searchCouponButton;
    @FindBy(css = "h4.alert-heading")
    private WebElement couponCreatedMessage;
    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody/tr")
    private List<WebElement> allSearchTableLines;

    public CouponsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CouponsPage createNewCoupon(String couponName, String validDate, int numberOfCoupons) {
        createNewCouponButton.click();
        couponNameField.sendKeys(couponName);
        validDateField.sendKeys(validDate);
        numberOfCouponsField.clear();
        numberOfCouponsField.sendKeys(String.valueOf(numberOfCoupons));
        sumbitButton.submit();
        return this;
    }

    public CouponsPage searchCoupon(String couponName) {
        searchField.clear();
        searchField.sendKeys(couponName);
        searchCouponButton.click();
        return this;
    }

    public CouponsPage deleteCoupon() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        deleteCouponButton.click();
        TimeUnit.MILLISECONDS.sleep(1100);
        confirmButton.click();
        return this;
    }

    public String getCouponCreatedMessage() {
        return couponCreatedMessage.getText();
    }

    public boolean getSearchTableIsEmpty() {
        return allSearchTableLines.isEmpty();
    }

    public boolean getSearchTableHasNewCoupon(String couponName) {
        return !allSearchTableLines.isEmpty();
    }

    public int getSearchTableSize() {
        return allSearchTableLines.size();
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public boolean getСouponIsDeleted() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1100);
        return !allSearchTableLines.get(0).isDisplayed();
    }

}
