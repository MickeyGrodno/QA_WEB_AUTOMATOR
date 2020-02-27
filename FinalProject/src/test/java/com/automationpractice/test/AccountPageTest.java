package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPageTest extends DataFixture {
    @Test
    public void createAndCheckOrderTest() {
        String orderName;
        mainPage.addFirstProductInCartWithSetQuantity("5");
        mainPage.goToShoppingCartPage();
        orderName = shoppingCartPage.createOrderAndGetOrderName();
        assertTrue(myAccountPage.orderIsPresent(orderName));
    }
}

