import com.codeborne.selenide.SelenideElement;
import org.example.models.BreadCrumbs;
import org.example.models.TestData;
import org.example.models.UserData;
import org.example.steps.LoginSteps;
import org.example.steps.ProductsSteps;
import org.example.utils.ClosePopUp;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OmaTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    ProductsSteps productsSteps = new ProductsSteps();
    ClosePopUp closePopUp = new ClosePopUp();

    @Test(dataProvider = "UserData", dataProviderClass = JsonReader.class)
    public void loginTest(UserData userData) {
        loginSteps.login(userData.getPhoneNumber(), userData.getPassword());
        loginSteps.verifyLogin("Зинчук Александр Борисович");
    }

    @Test
    public void addCheapestItemToCart() {
        productsSteps.goToLaminatCategory();
        SelenideElement cheapestProduct = productsSteps.findCheapestPrice();
        String productName = cheapestProduct.find(".product-item_title").getText();
        productsSteps.addProductToCart(cheapestProduct);
        productsSteps.goToCart();
        productsSteps.verifyProductInCart(productName);
    }

    @Test(dataProvider = "TestData", dataProviderClass = JsonReader.class)
    public void compareProducts(TestData testData) {
        productsSteps.goToLaminatCategory();
        productsSteps.clickFirstAddToCartButton();
        closePopUp.closePopUps();
        productsSteps.goToCart();
        Assert.assertEquals(productsSteps.getProductData(), testData.getProductData());
    }

//    @Test
//    public void clickStoreAddressesText() {
//        productsSteps.clickStoreAddressesText("Адреса магазинов");
//    }

//    @Test(dataProvider = "BreadCrumbs", dataProviderClass = JsonReader.class)
//    public void compareBreadCrumbs(BreadCrumbs breadCrumbs) {
//        productsSteps.goToLaminatCategory();
//        productsSteps.clickFirstAddToCartButton();
//        productsSteps.goToCart();
//        Assert.assertEquals(productsSteps.getProductData(), testData.getProductData());
//    }
}
