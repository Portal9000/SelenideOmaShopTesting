import com.codeborne.selenide.SelenideElement;
import org.example.models.BreadCrumbs;
import org.example.models.TestData;
import org.example.steps.LoginSteps;
import org.example.steps.MainMenuSteps;
import org.example.steps.ProductsSteps;
import org.example.utils.ClosePopUp;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OmaTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    ProductsSteps productsSteps = new ProductsSteps();
    MainMenuSteps mainMenuSteps = new MainMenuSteps();
    ClosePopUp closePopUp = new ClosePopUp();

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void loginTest(TestData testData) {
        loginSteps.login(testData.getUserData().getPhoneNumber(), testData.getUserData().getPassword());
        loginSteps.verifyLogin("Зинчук Александр Борисович"); //TODO JSON
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

    @Test(dataProvider = "productData", dataProviderClass = JsonReader.class)
    public void compareProducts(TestData testData) {
        Assert.assertEquals(productsSteps.getProductData(), testData.getProductData()); //productsSteps.setProductData(testData.getProductData())
    }

//    @Test
//    public void clickStoreAddressesText() {
//        productsSteps.clickStoreAddressesText("Адреса магазинов");
//    }

    @Test(dataProvider = "breadCrumbs", dataProviderClass = JsonReader.class)
    public void checkBreadCrumbs(BreadCrumbs breadCrumbs) {
        System.out.println("starrrt");
        mainMenuSteps.clickMainMenu(breadCrumbs.getHeaderMenu());
        Assert.assertEquals(breadCrumbs.getBreadCrumb(), mainMenuSteps.getBreadCrumb());
    }
}
