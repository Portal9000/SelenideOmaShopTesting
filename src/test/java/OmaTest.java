import org.example.models.BreadCrumbs;
import org.example.models.UserData;
import org.example.steps.LoginSteps;
import org.example.steps.MainMenuSteps;
import org.example.steps.ProductsSteps;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OmaTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    ProductsSteps productsSteps = new ProductsSteps();
    MainMenuSteps mainMenuSteps = new MainMenuSteps();

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void loginTest(UserData userData) {
        loginSteps.login(userData.getPhoneNumber(), userData.getPassword());
        loginSteps.verifyLogin(userData.getAccountOwnerName());
    }

    @Test()
    public void compareProducts() {
        String productName, productPrice;
        mainMenuSteps.goToLaminatCategory();
        productName = productsSteps.ProdNameFromCategory();
        productPrice = productsSteps.ProdPriceFromCategory();
        productsSteps.clickFirstAddToCartButton();
        productsSteps.goToCart();
        Assert.assertEquals(productName, productsSteps.getProductDataFromCart().getProductName());
        Assert.assertEquals(productPrice, productsSteps.getProductDataFromCart().getProductPrice()
                .replace(" р. / шт", "")
                .replace(" р.", "")
                .replace(" руб.", ""));
    }

    @Test(dataProvider = "breadCrumbs", dataProviderClass = JsonReader.class)
    public void checkBreadCrumbs(BreadCrumbs breadCrumbs) {
        mainMenuSteps.clickMainMenu(breadCrumbs.getHeaderMenu());
        Assert.assertEquals(breadCrumbs.getBreadCrumb(), mainMenuSteps.getBreadCrumb(breadCrumbs.getBreadCrumb()));
    }
}