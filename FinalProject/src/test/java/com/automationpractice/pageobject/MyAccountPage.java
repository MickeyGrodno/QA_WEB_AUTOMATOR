package com.automationpractice.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {
    SelenideElement ordersButton = $(By.xpath("//a [@title= 'Orders']"));

    public boolean orderIsPresent(String orderName) {
        ordersButton.click();
        return $(By.xpath("//a[contains(text(),'"+orderName+"')]")).exists();
    }
    public String checkoutAndGetOrderName() {
        String line, orderName;
       $(By.xpath("//p/a[@title = 'Proceed to checkout']")).click();
       $(By.name("processAddress")).click();
       $(By.id("cgv")).click();
       $(By.name("processCarrier")).click();
       $(By.className("bankwire")).click();
       $(By.xpath("//span[text()='I confirm my order']")).click();
       line = $(By.xpath("//body//br[5]")).getText();
       orderName = line.split(" ")[9];
       $(By.className("account")).click();
       return orderName;
    }
}
