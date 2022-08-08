package pages.smallBuiness;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;


public class SmallBusinessPage {
    private final SelenideElement tg        = $x("//a[@aria-label='Telegram']");
    private final SelenideElement vk        = $x("//a[@aria-label='Vk']");
    private final SelenideElement ok        = $x("//a[@aria-label='Ok']");
    private final SelenideElement account   = $x("//div[contains(@class, 'MenuHolder')]/child::a[1]");



    @Step("Проверяем валидность ссылки на телеграмм")
    public SmallBusinessPage checkTGUrl() {
        String tgUrl = tg.getAttribute("href");

        tg.shouldBe(Condition.visible, Duration.ofSeconds(30))
                .scrollTo().click();
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(tgUrl), Duration.ofSeconds(5));
        return this;
    }


    @Step("Проверяем валидность ссылки на вконтакте")
    public SmallBusinessPage checkVKUrl() {
        String vkUrl = vk.getAttribute("href");

        vk.shouldBe(Condition.visible, Duration.ofSeconds(30))
                .scrollTo().click();
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(vkUrl), Duration.ofSeconds(5));
        return this;
    }


    @Step("Проверяем валидность ссылки на одноклассники")
    public SmallBusinessPage checkOKUrl() {
        String okUrl = ok.getAttribute("href");

        ok.shouldBe(Condition.visible, Duration.ofSeconds(30))
                .scrollTo().click();
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(okUrl), Duration.ofSeconds(5));
        return this;
    }

    @Step("Переход на вкладку Расчетный счет")
    public SmallBusinessAccountPage gotoAccount() {
        account.shouldBe(Condition.visible).click();
        return new SmallBusinessAccountPage();
    }
}
