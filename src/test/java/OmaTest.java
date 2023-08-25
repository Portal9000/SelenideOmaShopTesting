import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
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
//        if ($(By.xpath("//div[@class='backdrop-close']")).isDisplayed()) {
//            $(By.xpath("//div[@class='backdrop-close']")).click();
//        }
//        if ($(By.xpath("//div[@class='backdrop-close']")).isDisplayed()) {
//            $(By.xpath("//div[@class='backdrop-close']")).click();
//        }
//        $(By.xpath("//button[@name=\"SET_LOGIN\"]")).click();
    }

    public SelenideElement findCheapestPrice() {
        ElementsCollection productPrices = $$(By.xpath("//span[@class=\"price__normal black\"]"));  // TODO change? //div[@class="product-price-block"]
        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;
        for (SelenideElement productPrice : productPrices) {
            SelenideElement product = productPrice.closest("div[contains(@class, 'product-item_title')]");  // TODO change? div[contains(@class, 'product-item_title')]
            String priceText = productPrice.getText().replace(" р. / шт", "").replace(",", ".");  // TODO че с пробелом?
            System.out.println("a|" + priceText + "|b");
            double price = Double.parseDouble(priceText);
            if (price < lowestPrice) {
                lowestPrice = price;
                cheapestProduct = product;
            }
        }
        System.out.println(cheapestProduct.getText());     //TODO LOG
        return cheapestProduct;
    }

    public void addProductToCart(SelenideElement product) {
        product.find(".btn btn__catalog btn-bg_blue js_orderButton").click(); // //button[@class="btn btn__catalog btn-bg_blue js_orderButton "]
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
        String productName = cheapestProduct.find(By.xpath("//a[@class=\"basket-product-item_title js-broadcast-hover\"]")).getText();
        addProductToCart(cheapestProduct);
        goToCart();
        verifyProductInCart(productName);
    }
}
