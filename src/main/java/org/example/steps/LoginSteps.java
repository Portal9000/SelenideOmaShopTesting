package org.example.steps;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.PopUpPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    PopUpPage popUpPage = new PopUpPage();

    public void login(String phoneNumber, String password) {
        mainPage.commonLoginRegisterButton.click();
        loginPage.phoneNumberField.setValue(phoneNumber);
        loginPage.passwordField.setValue(password);
        loginPage.agreeCheckbox.click();
        if (popUpPage.popUp.isDisplayed()) {
            popUpPage.popUp.click();
        }
        loginPage.loginButton.hover().click();
    }

    public void verifyLogin(String accountOwnerName) {
        mainPage.personalAccountOwnerName.shouldHave(text(accountOwnerName));
    }
}
