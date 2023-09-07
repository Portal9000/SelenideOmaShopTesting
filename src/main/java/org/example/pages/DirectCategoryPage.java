package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DirectCategoryPage {

    public SelenideElement laminatCategoryPage = $(By.xpath("//div[@data-items-visible='11']/a[@href='/laminat-c']"));
    public SelenideElement firstAddToCartButton = $$(By.xpath("//button[@class=\"btn btn__catalog btn-bg_blue js_orderButton \"]")).first();
    public ElementsCollection productPricesText = $$(By.xpath("//div[@id='data-ga__catalog-products-grid']//span[@class='price__normal black']"));
    public SelenideElement goToCartButton = $(By.xpath("//a[@href='/order/']"));

    public SelenideElement storeAdressesText(String storeAdresses) {
        return $(By.xpath("//a[contains(@class,'header-top_item')]//span[contains(text(),'" + storeAdresses + "')]"));
    }
}