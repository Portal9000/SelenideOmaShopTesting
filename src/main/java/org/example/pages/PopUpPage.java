package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class PopUpPage {

    public SelenideElement popUp = $(By.xpath("//div[@class='backdrop-close']"));

}
