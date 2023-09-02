package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.CartPage;
import org.example.pages.DirectCategoryPage;
import org.example.pages.MainPage;
import org.example.pages.PopUpPage;
import static com.codeborne.selenide.Condition.text;

public class ProductsSteps {

    MainPage mainPage = new MainPage();
    DirectCategoryPage directCategoryPage = new DirectCategoryPage();
    CartPage cartPage = new CartPage();
    PopUpPage popUpPage = new PopUpPage();

    public SelenideElement findCheapestPrice() {
        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;
        for (SelenideElement productPrice : directCategoryPage.productPricesText) {   // TODO add red
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
        mainPage.chooseCommonCategoryOtdelka.click();
        directCategoryPage.laminatCategoryPage.click();
    }

    public void addProductToCart(SelenideElement product) {
        if (popUpPage.popUp.isDisplayed()) {
            popUpPage.popUp.click();
        }
        product.find(".js_orderButton").scrollIntoView("{block: \"center\"}").hover().click();
    }

    public void goToCart() {
        cartPage.goToCartButton.click();
    }

    public void verifyProductInCart(String productName) {
        cartPage.productNameInCart
                .filter(text(productName))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
