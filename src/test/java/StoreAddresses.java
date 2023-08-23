import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StoreAddresses {

//    @Test
//    public void loginTest() {
//        open("https://www.saucedemo.com/");
//        $(By.id("user-name")).setValue("standard_user");
//        $(By.id("password")).setValue("secret_sauce");
//        $(By.id("login-button")).click();
//        $(By.xpath("//span[@class='title']")).shouldHave(text("Products"));
//    }

    @Test
    public void addressesTitleTest() {
        open("https://www.oma.by");
        $(By.xpath("//span[@class=\"header-top_item-txt hidden-sm\"]")).click();
        $(By.xpath("//div[@class=\"page-title_title-cell\"]")).shouldHave(text("Адреса магазинов"));
    }
}