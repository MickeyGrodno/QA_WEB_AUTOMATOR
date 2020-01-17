package com.qawa.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CouponsPage {
    private WebDriver driver;
    private Logger log = Logger.getLogger(CouponsPage.class);
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
        try {
            createNewCouponButton.click();
            couponNameField.sendKeys(couponName);
            log.info("Send keys " + couponName);
            validDateField.sendKeys(validDate);
            log.info("Send keys " + validDate);
            numberOfCouponsField.clear();
            numberOfCouponsField.sendKeys(String.valueOf(numberOfCoupons));
            log.info("Send keys " + numberOfCoupons);
            sumbitButton.submit();
            log.warn("Coupon with name " + couponName + " created!");
        } catch (IllegalArgumentException e) {
            log.fatal("Fields 'coupon name', 'valid date' and 'number of coupons' cannot be null");
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return this;
    }

    public CouponsPage searchCoupon(String couponName) {
        try {
            searchField.clear();
            searchField.sendKeys(couponName);
            log.info("Send keys " + couponName);
            searchCouponButton.click();
        } catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return this;
    }

    public CouponsPage deleteCoupon() throws InterruptedException {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            deleteCouponButton.click();
            TimeUnit.MILLISECONDS.sleep(1100);
            confirmButton.click();
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return this;
    }

    public String getCouponCreatedMessage() {
        String text = "";
        try {
            text = couponCreatedMessage.getText();
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return text;
    }

    public boolean getSearchTableIsEmpty() {
        boolean tableIsEmpty = false;
        try {
            tableIsEmpty = allSearchTableLines.isEmpty();
        } catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return tableIsEmpty;
    }

    public boolean getSearchTableHasNewCoupon(String couponName) {
        boolean tableHasNewCoupon = false;
        searchCoupon(couponName);
        try {
            tableHasNewCoupon = !allSearchTableLines.isEmpty();
        } catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return tableHasNewCoupon;
    }

    public int getSearchTableSize() {
        int size = 0;
        try {
            size = allSearchTableLines.size();
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return size;
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public boolean getCouponIsDeleted() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1100);
        boolean couponIsDeleted = false;
        try {
            couponIsDeleted = !allSearchTableLines.get(0).isDisplayed();
        }
        catch (NoSuchElementException e) {
            log.fatal("WebElement not found");
        }
        return couponIsDeleted;
    }
}
