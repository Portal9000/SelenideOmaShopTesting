import com.codeborne.selenide.SelenideElement;
import org.example.steps.LoginSteps;
import org.example.steps.ProductsSteps;
import org.testng.annotations.Test;

public class OmaTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    ProductsSteps productsSteps = new ProductsSteps();

    @Test(enabled = false)
    public void loginTest() {
        loginSteps.login("293305742", "c114b9b2");
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
