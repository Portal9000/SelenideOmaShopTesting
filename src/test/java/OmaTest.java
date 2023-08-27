import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class OmaTest {

    @BeforeMethod
    public void goToUrl() {
        open("https://www.oma.by");
    }

    public void login (String phoneNumber, String password) {
        $(By.xpath("//span[@class='icon icon__person']")).click();
        $(By.xpath("//input[@placeholder='+375 (__) ___-__-__']")).setValue(phoneNumber);
        $(By.xpath("//input[@name='PASSWORD']")).setValue(password);
        $(By.xpath("//span[@class=\"checkbox-visual_icon icon icon__check\"]")).click();
        if ($(By.xpath("//div[@class='backdrop-close']")).isDisplayed()) {
            $(By.xpath("//div[@class='backdrop-close']")).click();
        }
        $(By.xpath("//button[@name=\"SET_LOGIN\"]")).hover().click();
    }

    public SelenideElement findCheapestPrice() {
        ElementsCollection productPrices = $$(By.xpath("//div[@id=\"data-ga__catalog-products-grid\"]//span[@class=\"price__normal black\"]"));
        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;
        int x=0;
        for (SelenideElement productPrice : productPrices) {
            SelenideElement product = productPrice.closest("div[contains(@class, 'product-item__grid')]");                     // TODO нужен весь блок?
            String priceText = productPrice.getText().replace(" р. / шт", "").replace(",", ".");
            x++;
            System.out.println(x + " a|" + priceText + "|b");
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
                .filter(Condition.text(productName))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

//    @Test
//    public void loginTest() {
//        login("293305742", "c114b9b2");
//        $(By.xpath("//h2[@class=\"personal-user_name\"]")).shouldHave(text("Зинчук Александр Борисович"));
//    }

    @Test
    public void addItemToCart() {
//        login("293305742", "c114b9b2");
        $(By.xpath("//a[@href=\"/interer-i-otdelka-c\"]")).click();
        $(By.xpath("//div[@data-items-visible='11']/a[@href=\"/laminat-c\"]")).click();
        SelenideElement cheapestProduct = findCheapestPrice();
        String productName = cheapestProduct.find(".product-item_title").getText();
        addProductToCart(cheapestProduct);
        goToCart();
        verifyProductInCart(productName);
    }
}
