package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends DataFixture {
    @Test
    public void searchForAvailableProducts() {
        assert(mainPage.searchAndFoundAnyProduct("T-shirt"));
    }

    @Test
    public void productNotFoundTest(){
        assertTrue(mainPage.searchAndNotFoundProduct("pants"));
    }
}
