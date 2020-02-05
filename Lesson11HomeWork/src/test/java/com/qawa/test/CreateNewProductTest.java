package com.qawa.test;

import com.qawa.pageobjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CreateNewProductTest extends DataFixture{
    @Disabled
    @Test
    public void createNewProductAndCheck() {
        loginPage = new LoginPage();
        userPanel = loginPage.loginWithUserData(email,password);
        productPage = userPanel.goToProductsPage();
        productPage.createNewProduct();
        productPage.setGeneralInformation(price, currency, title, description);
        productPage.setDetails(priceOffer, offerValid);
        productPage.setAdditionalInformation(version, featureProduct);
        productPage.setSupportDetails(licenses, licenseDays, supportDays);
        productPage.checkAndClickActiveCheckBoxAndSaveProduct();
        productPage.searchAndClickNewProductUrl(title);
        Assertions.assertTrue(productPage.checkCorrectPage());

    }


    @Test
    public void searchTest() {
        loginPage = new LoginPage();
        userPanel = loginPage.loginWithUserData(email,password);
        productPage = userPanel.goToProductsPage();
        productPage.searchAndClickNewProductUrl(title);
        Assertions.assertTrue(productPage.checkCorrectPage());
    }
}
