package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement phoneNumberField = $(By.xpath("//input[@placeholder='+375 (__) ___-__-__']"));
    public SelenideElement passwordField = $(By.xpath("//input[@name='PASSWORD']"));
    public SelenideElement agreeCheckbox = $(By.xpath("//span[@class='checkbox-visual_icon icon icon__check']"));
    public SelenideElement loginButton = $(By.xpath("//button[@name='SET_LOGIN']"));
}
