package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

@Owner("автор - Александр Черняев")
public abstract class BaseTest {

    @Before
    public void init() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.pageLoadTimeout = 45000;
        Configuration.timeout = 30000;
        Configuration.headless = false;
        Configuration.savePageSource = false;
        Configuration.baseUrl = "https://www.mtsbank.ru";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );

    }

    /*public void init() {
        WebDriverManager.chromedriver().cachePath("D:\\Apps\\tools\\drivers\\chrome").setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
        Configuration.savePageSource = false;
        Configuration.baseUrl = "https://www.mtsbank.ru";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }*/
    @Step("Драйвер, давай до свидания")
    @After
    public void shutDown() {
        Selenide.closeWebDriver();
    }

}
