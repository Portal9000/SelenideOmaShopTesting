package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DirectCategoryPage {

    public SelenideElement laminatCategoryPage = $(By.xpath("//div[@data-items-visible='11']/a[@href='/laminat-c']"));
    public SelenideElement firstAddToCartButton = $$(By.xpath("//button[@class=\"btn btn__catalog btn-bg_blue js_orderButton \"]")).first();
    public ElementsCollection productNamesInCat = $$(By.xpath("//div[@id='data-ga__catalog-products-grid']//div[@class='wrapper']"));
    public ElementsCollection productPricesInCat = $$(By.xpath("//div[@id='data-ga__catalog-products-grid']//span[contains(@class,'price__normal')]"));
    public SelenideElement goToCartButton = $(By.xpath("//a[@href='/order/']"));
}