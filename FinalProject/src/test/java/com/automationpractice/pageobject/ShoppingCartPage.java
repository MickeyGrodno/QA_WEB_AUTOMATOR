package com.automationpractice.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    public double getAllProductsPrice() {
        double allProdPrice = 0;
        ElementsCollection priceElements = $$("td.cart_total>span");
        for (SelenideElement element : priceElements){
            String price = element.$("td.cart_total>span")
                    .getText()
                    .substring(2);
            allProdPrice += Double.parseDouble(price);
        }
        return allProdPrice;
    }

    public double getTotalProductsPrice() {
        double totalProduct;
        totalProduct = Double.parseDouble($(By.xpath("//td[@id='total_product']"))
                .getText()
                .substring(2));
        return totalProduct;
    }

    public boolean getCartIsNotEmpty() {
        return $("table.table").exists();
    }

    public ShoppingCartPage setProductQuantity(String value) {
        $("input.cart_quantity_input").clear();
        $("input.cart_quantity_input").setValue(value);
        return this;
    }

    public ShoppingCartPage deleteFirstProduct() {
        $("td.cart_delete>div>a").click();
        return this;
    }
}
