package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class PopUpPages {

    public SelenideElement popUp1btn = $(By.xpath("//div[@class='backdrop-close']"));
    public SelenideElement popUp1bgr = $(By.xpath("//body[@class='catalog-page no-touch no-ios']"));
}
