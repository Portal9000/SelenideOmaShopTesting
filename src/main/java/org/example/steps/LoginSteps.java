package org.example.steps;

import org.example.models.ProductData;
import org.example.models.UserData;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.PopUpPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    PopUpPages popUpPage = new PopUpPages();

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

//    public UserData setUserData(UserData userData) {
//        userData.setPhoneNumber(userData.getPhoneNumber());
//        userData.setPassword(userData.getPassword());
//        return userData;
//    }
//
//    public UserData getUserData() {
//        UserData userData = new UserData();
//        userData.setPhoneNumber(loginPage.phoneNumberField.getText());
//        userData.setPassword(loginPage.passwordField.getText());
//        return userData;
//    }
}
