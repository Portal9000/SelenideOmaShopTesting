package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class PopUpPages {

    public SelenideElement popUp1btn = $(By.xpath("//div[@class='backdrop-close']"));
    public SelenideElement popUp1msg = $(By.xpath("//div[@class='backdrop-message']"));
//    public SelenideElement popUp1bgr = $(By.xpath("//div[@class='sp-backdrop-info show-prompt']"));
    public SelenideElement popUp1bgr = $(By.xpath("//body[@class='catalog-page no-touch no-ios']"));


    public SelenideElement popUp2 = $(By.xpath("//button[@class=\"btn btn__dark js-button-submit\"]"));
    public SelenideElement popUp3 = $(By.xpath("//div[@class=\"popmechanic-close\"]"));
    public SelenideElement popUp4 = $(By.xpath("//button[@id=\"close-btn\"]"));
    public SelenideElement popUp5 = $(By.xpath("//div[@class=\"dy-sl-popup-recs-close\"]"));

}
