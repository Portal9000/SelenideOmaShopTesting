package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement commonLoginRegisterButton = $(By.xpath("//span[@class='icon icon__person']"));
    public SelenideElement personalAccountOwnerName = $(By.xpath("//h2[@class='personal-user_name']"));
    public SelenideElement chooseCommonCategoryOtdelka = $(By.xpath("//a[@href='/interer-i-otdelka-c']"));
    public SelenideElement headerMenuButtons(String headerMenu) {
        return $(By.xpath("//div[contains(@class, 'header-menu')]//a[contains(@href, '" + headerMenu + "')]"));
        //div[@class='header-menu_item ']//a[contains(text(),'" + headerMenu + "')]
    }
    public SelenideElement breadCrumbName(String breadCrumb) {
        return $(By.xpath("//h1[contains(text(),'" + breadCrumb + "')]"));
        //div[@class='breadcrumbs_item  ']//span[contains(text(),'" + breadCrumb + "')]
    }
}
