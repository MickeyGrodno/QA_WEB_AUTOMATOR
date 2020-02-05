package com.qawa.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ProductPage {
    private SelenideElement newProductButton = $(By.xpath("//a[@class='btn btn-primary pull-right']"));
    private SelenideElement categoryRadioButton = $(By.xpath("//input[@id='radio_cat']"));
    private SelenideElement priceField = $(By.xpath("//input[@id='price']"));
    private SelenideElement currencyField = $(By.xpath("//a[@class='chosen-single chosen-default']"));
    private SelenideElement currencyTextField = $(By.xpath("//div[@class='chosen-search']//input[@class='form-control']"));
    private SelenideElement titleField = $(By.xpath("//input[@id='title']"));
    private SelenideElement descriptionField = $(By.xpath("//body"));
    private SelenideElement priceOfferField = $(By.xpath("//input[@id='price_offer']"));
    private SelenideElement offerValidField = $(By.xpath("//input[@id='offer_valid']"));
    private SelenideElement licensesField = $(By.xpath("//input[@id='licenses']"));
    private SelenideElement licenseDaysField = $(By.xpath("//input[@id='license_days']"));
    private SelenideElement supportDaysField = $(By.xpath("//input[@id='support_days']"));
    private SelenideElement versionField = $(By.xpath("//input[@id='version']"));
    private SelenideElement featureProductField = $(By.xpath("//input[@id='featured']"));
    private SelenideElement activeCheckBox = $(By.xpath("//input[@name='status']"));
    private SelenideElement saveProductButton = $(By.xpath("//button[@name='submit']"));
    private SelenideElement lastProductPageButton = $(By.xpath("//a[@id='last']"));;
    private ElementsCollection searchedElements;

    public ProductPage() {
    }
    public ProductPage createNewProduct() {
        newProductButton.click();
        return this;
    }

    public void setGeneralInformation(int price, String currency, String title, String description){
        categoryRadioButton.click();
        priceField.setValue(String.valueOf(price));
        currencyField.click();
        currencyTextField.setValue(currency);
        titleField.setValue(title);

        switchTo().frame(0);
        descriptionField.setValue(description);
        switchTo().defaultContent();
    }

    public void setDetails(int priceOffer, int offerValid) {
        priceOfferField.setValue(String.valueOf(priceOffer));
        offerValidField.setValue(String.valueOf(offerValid));
    }

    public void setSupportDetails(int licenses, int licenseDays, int supportDays) {
        licensesField.setValue(String.valueOf(licenses));
        licenseDaysField.setValue(String.valueOf(licenseDays));
        supportDaysField.setValue(String.valueOf(supportDays));
    }

    public void  setAdditionalInformation(int version, int featureProduct) {
        versionField.setValue(String.valueOf(version));
        featureProductField.setValue(String.valueOf(featureProduct));
    }

    public ProductPage checkAndClickActiveCheckBoxAndSaveProduct() {
        if(!activeCheckBox.isSelected()) {
            activeCheckBox.click();
        }
        saveProductButton.click();
        return this;
    }

    public void searchAndClickNewProductUrl(String title) {
        lastProductPageButton.click();
        searchedElements = $$(By.xpath(".//td[text()='"+title+"']/.."));

        searchedElements.last().click();
        switchTo().window(1);
    }

    public boolean checkCorrectPage() {
        if(!$$(withText("Product not found")).isEmpty()) {
            return true;
        }
        else return false;
    }
}
