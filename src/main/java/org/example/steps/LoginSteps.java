package org.example.steps;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginSteps {

    public void login(String phoneNumber, String password) {
        $(By.xpath("//span[@class='icon icon__person']")).click();
        $(By.xpath("//input[@placeholder='+375 (__) ___-__-__']")).setValue(phoneNumber);
        $(By.xpath("//input[@name='PASSWORD']")).setValue(password);
        $(By.xpath("//span[@class=\"checkbox-visual_icon icon icon__check\"]")).click();
        if ($(By.xpath("//div[@class='backdrop-close']")).isDisplayed()) {
            $(By.xpath("//div[@class='backdrop-close']")).click();
        }
        $(By.xpath("//button[@name=\"SET_LOGIN\"]")).hover().click();
    }
}
