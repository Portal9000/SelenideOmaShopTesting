package org.example.steps;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import static com.codeborne.selenide.Condition.text;

public class LoginSteps {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    public void login(String phoneNumber, String password) {
        mainPage.commonLoginRegisterButton.click();
        loginPage.phoneNumberField.setValue(phoneNumber);
        loginPage.passwordField.setValue(password);
        loginPage.agreeCheckbox.click();
        loginPage.loginButton.hover().click();
    }

    public void verifyLogin(String accountOwnerName) {
        mainPage.personalAccountOwnerName.shouldHave(text(accountOwnerName));
    }
}
