package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.example.models.ProductData;
import org.example.pages.CartPage;
import org.example.pages.DirectCategoryPage;
import org.example.pages.MainPage;
import org.example.utils.ClosePopUp;
import org.example.utils.Waiters;

import static com.codeborne.selenide.Condition.text;

public class ProductsSteps {

    MainPage mainPage = new MainPage();
    DirectCategoryPage directCategoryPage = new DirectCategoryPage();
    CartPage cartPage = new CartPage();
    ClosePopUp closePopUp = new ClosePopUp();

    public void goToCart() {
        directCategoryPage.goToCartButton.click();
    }

    public void clickFirstAddToCartButton() {
        directCategoryPage.firstAddToCartButton.scrollIntoView("{block: \"center\"}").hover().click();
    }

    public String ProdNameFromCategory() {
        return directCategoryPage.productNamesInCat.get(0).getText();
    }
    public String ProdPriceFromCategory() {
        return directCategoryPage.productPricesInCat.get(0).getText()
                .replace(" р. / шт", "")
                .replace(" р.", "")
                .replace(" руб.", "");
    }

    public ProductData getProductDataFromCart() {
        ProductData productData = new ProductData();
        productData.setProductName(cartPage.productNameInCart.getText());
        productData.setProductPrice(cartPage.productPriceInCart.getText());
        return productData;
    }
}
