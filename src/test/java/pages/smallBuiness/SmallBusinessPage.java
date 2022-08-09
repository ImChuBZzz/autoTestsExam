package pages.smallBuiness;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.closeWindow;


public class SmallBusinessPage {
    private final SelenideElement tg = $x("//a[@aria-label='Telegram']");
    private final SelenideElement vk = $x("//a[@aria-label='Vk']");
    private final SelenideElement ok = $x("//a[@aria-label='Ok']");
    private final SelenideElement account = $x("//div[contains(@class, 'MenuHolder')]/child::a[1]");

    @Step("Выбираем телеграмм")
    public SmallBusinessPage tgUrl() {
        tg.shouldBe(Condition.visible)
                .scrollTo().click();
        return this;
    }

    @Step("Проверяем валидность ссылки на телеграмм")
    public SmallBusinessPage checkTgUrl(String url) {
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(url));
        closeWindow();
        return this;
    }

    @Step("Выбираем вКонтакте")
    public SmallBusinessPage vkUrl() {
        vk.shouldBe(Condition.visible)
                .scrollTo().click();
        return this;
    }

    @Step("Проверяем валидность ссылки на вконтакте")
    public SmallBusinessPage checkVkUrl(String url) {
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(url));
        closeWindow();
        return this;
    }

    @Step("Выбираем одноклассники")
    public SmallBusinessPage okUrl() {
        ok.shouldBe(Condition.visible)
                .scrollTo().click();
        return this;
    }

    @Step("Проверяем валидность ссылки на одноклассники")
    public SmallBusinessPage checkOkUrl(String url) {
        Selenide.switchTo().window(1);
        Selenide.webdriver().shouldHave(WebDriverConditions.url(url));
        closeWindow();
        return this;
    }

    @Step("Переход на вкладку Расчетный счет")
    public SmallBusinessAccountPage gotoAccount() {
        account.shouldBe(Condition.visible).click();
        return new SmallBusinessAccountPage();
    }
}
