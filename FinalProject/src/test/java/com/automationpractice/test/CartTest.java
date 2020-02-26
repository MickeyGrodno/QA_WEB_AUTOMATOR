package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends DataFixture {
    @Test
    public void addProductInCartTest() {
        int allAddedDresses;
        allAddedDresses = mainPage.addAllDressesToCart();
        assertEquals(allAddedDresses, mainPage.goToShoppingCartPage().getNumberOfProductsInCart());
    }

    @Test
    public void addZeroQuantityOfProducts() {
        mainPage.addProductsInCart("0");
        assertEquals(0, mainPage.goToShoppingCartPage().getNumberOfProductsInCart());
    }

    @Test
    public void correctAmountInCart() {
        double allProdPrice;
        mainPage.addAllDressesToCart();
        allProdPrice = mainPage.goToShoppingCartPage().getAllProductsPrice();
        assertEquals(allProdPrice, shoppingCartPage.getTotalProductsPrice());
    }

}
