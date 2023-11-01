package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.example.models.ProductData;
import org.example.pages.CartPage;
import org.example.pages.DirectCategoryPage;
import org.example.pages.MainPage;
import org.example.pages.PopUpPages;
import org.example.utils.ClosePopUp;
import org.example.utils.Waiters;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;

public class ProductsSteps {

    MainPage mainPage = new MainPage();
    DirectCategoryPage directCategoryPage = new DirectCategoryPage();
    CartPage cartPage = new CartPage();
    ClosePopUp closePopUp = new ClosePopUp();

    public SelenideElement findCheapestPrice() {
        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;
        for (SelenideElement productPrice : directCategoryPage.productPricesText) {
            SelenideElement product = productPrice.closest("div[contains(@class, 'product-item__grid')]");        // TODO нужны все страницы
            String priceText = productPrice.getText();
            double price = Double.MAX_VALUE;
            if (priceText != null && !priceText.equals("")) {
                priceText = priceText
                        .replace(" р. / шт", "")
                        .replace(",", ".")
                        .replace(" р.", "");
                price = Double.parseDouble(priceText);
                if (price < lowestPrice && price > 0) {
                    lowestPrice = price;
                    cheapestProduct = product;
                }
            }
        }
        return cheapestProduct;
    }

    public void goToLaminatCategory() {
        mainPage.chooseCommonCategoryOtdelka.click();
        directCategoryPage.laminatCategoryPage.click();
        Waiters.sleep();
    }

    public void addProductToCart(SelenideElement product) {
        product.find(".js_orderButton").scrollIntoView("{block: \"center\"}").hover().click();
    }

    public void goToCart() {
        directCategoryPage.goToCartButton.click();
    }

    public void verifyProductInCart(String productName) {
        cartPage.productNameInCart
                .filter(text(productName))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    public void clickFirstAddToCartButton() {
        directCategoryPage.firstAddToCartButton.scrollIntoView("{block: \"center\"}").hover().click();
    }

    public ProductData setProductData(ProductData productData) {
        productData.setProductName(productData.getProductName());
        productData.setProductPrice(productData.getProductPrice());
        return productData;
    }

    public ProductData getProductData() {
        ProductData productData = new ProductData();
        productData.setProductName(cartPage.productNameInCart.get(0).getText());
        productData.setProductPrice(cartPage.productPriceInCart.getText());
        return productData;
    }

    public void clickStoreAddressesText(String storeAddresses) {
        directCategoryPage.storeAddressesText(storeAddresses).click();
    }
}
