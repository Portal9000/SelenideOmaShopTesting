package org.example.steps;

import org.example.models.ProductData;
import org.example.pages.CartPage;
import org.example.pages.DirectCategoryPage;

public class ProductsSteps {

    DirectCategoryPage directCategoryPage = new DirectCategoryPage();
    CartPage cartPage = new CartPage();

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
