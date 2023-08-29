import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.logging.Level;
import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public void start() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
        Configuration.browserSize = "1600x900";
        Configuration.browser = CHROME;
    }

    @BeforeMethod
    public void goToUrl() {
        open("https://www.oma.by");
    }
}
