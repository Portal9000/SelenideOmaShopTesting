package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public SelenideElement goToCartButton = $(By.xpath("//a[@href=\"/order/\"]"));
    public ElementsCollection productNameInCart = $$(By.xpath("//a[@class=\"basket-product-item_title js-broadcast-hover\"]"));
}