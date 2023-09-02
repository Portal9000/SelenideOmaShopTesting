import com.codeborne.selenide.SelenideElement;
import org.example.models.UserData;
import org.example.steps.LoginSteps;
import org.example.steps.ProductsSteps;
import org.example.utils.JsonReader;
import org.testng.annotations.Test;

public class OmaTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    ProductsSteps productsSteps = new ProductsSteps();

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void loginTest(UserData userData) {
        loginSteps.login(userData.getPhoneNumber(), userData.getPassword());
        loginSteps.verifyLogin("Зинчук Александр Борисович");
    }

    @Test
    public void addItemToCart() {
        productsSteps.goToLaminatCategory();
        SelenideElement cheapestProduct = productsSteps.findCheapestPrice();
        String productName = cheapestProduct.find(".product-item_title").getText();
        productsSteps.addProductToCart(cheapestProduct);
        productsSteps.goToCart();
        productsSteps.verifyProductInCart(productName);
    }
}
