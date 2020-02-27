package com.automationpractice.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    public double getAllProductsPrice() {
        double allProdPrice = 0;
        ElementsCollection priceElements = $$("td.cart_total>span");
        for (SelenideElement element : priceElements){
            String price = element.getText().substring(1);
            allProdPrice += Double.parseDouble(price);
        }
        return allProdPrice;
    }

    public double getTotalProductsPrice() {
        double totalProduct;
        totalProduct = Double.parseDouble($(By.xpath("//td[@id='total_product']"))
                .getText()
                .substring(1));
        return totalProduct;
    }

    public int getNumberOfProductsInCart() {
        return $$("table.table>tbody>tr").size();
    }

    public ShoppingCartPage setProductQuantity(String value) {
        $("input.cart_quantity_input").clear();
        $("input.cart_quantity_input").setValue(value);
        return this;
    }

    public ShoppingCartPage deleteAllProducts() {
        ElementsCollection allProducts;
        allProducts = $$("td.cart_delete>div>a");
        for (SelenideElement element : allProducts) {
            element.click();
            element.should(hidden);
        }
        return this;
    }

    public String createOrderAndGetOrderName() {
        String orderName;
        String correctEmail = "Sergei199@list.ru";
        String correctPassword = "11111";
        LoginPage loginPage= new LoginPage();

        $("p.clearfix>a.button").click();
        loginPage.loginWithCorrectData(correctEmail, correctPassword);
        $(By.name("processAddress")).click();
        $(By.id("cgv")).click();
        $(By.name("processCarrier")).click();
        $(By.className("bankwire")).click();
        $(By.xpath("//span[text()='I confirm my order']")).click();
        orderName = getOrderNameFromText();
        $(By.className("account")).click();
        return orderName;
    }

    private String getOrderNameFromText(){
        String line = $("div.box").getAttribute("innerHTML");
        String part = line.split("<br>")[5];
        String needLine = part.split(" ")[9];
        return needLine;
    }
}
