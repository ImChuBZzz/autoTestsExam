package pages.cards;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CardOrder {
    private final SelenideElement phoneInput = $x("//input[@name='phone']");
    private final SelenideElement submitButton = $x("//form//button");
    private final ElementsCollection smsCode = $$x("//div//input");
    private final SelenideElement phoneError = $x("//form//div[@data-testid='text'][2]");

    @Step("Нажимаем для отправки кода подтверждения на номер")
    public CardOrder sendCode() {
        submitButton.shouldBe(Condition.enabled).click();
        return this;
    }

    @Step("Вводим телефон для получения кода подтверждения")
    public CardOrder inputPhone(String phone) {
        phoneInput.scrollTo().sendKeys(phone);
        return this;
    }

    @Step("Пустое значение в поле 'телефон'")
    public CardOrder inputEmptyPhone() {
        phoneInput.scrollTo().sendKeys("");
        return this;
    }

    @Step("Неверный номер!")
    public CardOrder warning(String message) {
        phoneError.shouldBe(Condition.exist).shouldHave(Condition.text(message));
        return this;
    }

    @Step("Все хорошо")
    public CardOrder ok() {
        phoneError.shouldNot(Condition.exist);
        return this;
    }

    @Step("Подтверждаем код из СМС")
    public CardOrder submitCode() {
        int SMS_CODE_SIZE = 4;
        smsCode.shouldHave(CollectionCondition.size(SMS_CODE_SIZE));
        return this;
    }
}
