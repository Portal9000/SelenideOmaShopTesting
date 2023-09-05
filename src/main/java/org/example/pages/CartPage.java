package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public ElementsCollection productNameInCart = $$(By.xpath("//a[@class='basket-product-item_title js-broadcast-hover']"));
    public SelenideElement productPriceInCart = $(By.xpath("//td[@class=\"basket-table_price\"]//div[@class=\"price__normal\"]"));
}