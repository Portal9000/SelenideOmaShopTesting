package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsSteps {

    public SelenideElement findCheapestPrice() {
        ElementsCollection productPrices = $$(By.xpath("//div[@id=\"data-ga__catalog-products-grid\"]//span[@class=\"price__normal black\"]"));  // TODO add red
        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;
        for (SelenideElement productPrice : productPrices) {
            SelenideElement product = productPrice.closest("div[contains(@class, 'product-item__grid')]");        // TODO нужен весь блок?
            String priceText = productPrice.getText().replace(" р. / шт", "").replace(",", ".");
            double price = Double.MAX_VALUE;
            if (priceText != "") {
                price = Double.parseDouble(priceText);
            }
            if (price < lowestPrice) {
                lowestPrice = price;
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }

    public void goToLaminatCategory() {
        $(By.xpath("//a[@href=\"/interer-i-otdelka-c\"]")).click();
        $(By.xpath("//div[@data-items-visible='11']/a[@href=\"/laminat-c\"]")).click();
    }

    public void addProductToCart(SelenideElement product) {
        if ($(By.xpath("//div[@class='backdrop-close']")).isDisplayed()) {
            $(By.xpath("//div[@class='backdrop-close']")).click();
        }
        product.find(".js_orderButton").scrollIntoView("{block: \"center\"}").hover().click();
    }

    public void goToCart() {
        $(By.xpath("//a[@href=\"/order/\"]")).click();
    }

    public void verifyProductInCart(String productName) {
        $$(By.xpath("//a[@class=\"basket-product-item_title js-broadcast-hover\"]"))
                .filter(text(productName))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
