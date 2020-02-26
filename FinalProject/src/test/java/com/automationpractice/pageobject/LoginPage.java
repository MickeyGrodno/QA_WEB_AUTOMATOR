package com.automationpractice.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement userEmail = $(By.id("email"));
    SelenideElement userPassword = $(By.id("passwd"));
    SelenideElement signInButton = $(By.id("SubmitLogin"));
    SelenideElement invalidPasswordAllert = $(By.xpath("//li [text()='Invalid password.']"));

    public MyAccountPage loginWithCorrectData(String email, String password) {
        userEmail.setValue(email);
        userPassword.setValue(password);
        signInButton.click();
        return new MyAccountPage();
    }

    public boolean loginWithIncorrectData(String email, String password) {
        userEmail.setValue(email);
        userPassword.setValue(password);
        signInButton.click();
        return invalidPasswordAllert.exists();
    }

}
