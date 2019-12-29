import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CouponsPage {
    private WebDriver driver;
    @FindBy(xpath = "//a [@href ='http://open-eshop.stqa.ru/oc-panel/Coupon/create']")
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
//    @FindBy(xpath = "//a [@datd-id='tr3005']")
    private WebElement deleteCouponButton;
    @FindBy(className = "confirm")
    private WebElement confirmButton;
    @FindBy(xpath = "//button [text() = 'Search']")
    private WebElement searchCouponButton;

    public CouponsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CouponsPage createNewCoupon(String couponName, String validDate, int numberOfCoupons) {
        createNewCouponButton.click();
        couponNameField.sendKeys(couponName);
        validDateField.sendKeys(validDate);
        numberOfCouponsField.sendKeys(String.valueOf(numberOfCoupons));
        sumbitButton.submit();
        return this;
    }

    public CouponsPage deleteCoupon(String couponName) throws InterruptedException {
        searchField.sendKeys(couponName);
        searchCouponButton.click();
        deleteCouponButton.click();
        TimeUnit.SECONDS.sleep(1);
        confirmButton.click();
        return this;
    }
}
