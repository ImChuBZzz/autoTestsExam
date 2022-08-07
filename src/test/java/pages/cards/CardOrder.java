package pages.cards;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CardOrder {
    private final SelenideElement phoneInput    = $x("//input[@name='phone']");
    private final SelenideElement submitButton  = $x("//form//button");
    private final ElementsCollection smsCode    = $$x("//div//input");
    private final SelenideElement correctPhone  = $x("//form//div[@data-testid='text'][2]");

    @Step("Ожидаем код на номер телефона {0} для подтверждения")
    public CardOrder visibleSmsCodeInput(String phone) {
        int SMS_CODE_SIZE = 4;
        phoneInput.scrollTo().sendKeys(phone);
        correctPhone.shouldNot(Condition.exist);
        submitButton.shouldBe(Condition.enabled).click();
        smsCode.shouldHave(CollectionCondition.size(SMS_CODE_SIZE));
        return this;
    }
}
