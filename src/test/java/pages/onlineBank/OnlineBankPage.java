package pages.onlineBank;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OnlineBankPage {
    private final SelenideElement submitButtom = $x("//button[@type='submit']");
    private final SelenideElement error = $x("//div[@data-testid='error']");
    private final SelenideElement inputPhone = $x("//input[@name='phone']");
    private final SelenideElement accessTerms = $x("//br/following-sibling::a[1]");
    private final SelenideElement privacyPolicy = $x("//br/following-sibling::a[2]");
    private final ElementsCollection smsCode = $$x("//div[@data-testid='digit']");

    @Step("Ввод корректного номера телефона")
    public OnlineBankPage inputCorrectPhone(String phone) {
        inputPhone.sendKeys(phone);
        return this;
    }

    @Step("Ввод некорректного номера телефона")
    public OnlineBankPage inputIncorrectPhone(String phone) {
        inputPhone.sendKeys(phone);
        return this;
    }

    @Step("Не вводим телефон")
    public OnlineBankPage inputEmptyPhone() {
        inputPhone.sendKeys("");
        return this;
    }

    @Step("Предупреждение есть")
    public OnlineBankPage errorExist(String message) {
        error.shouldBe(Condition.exist).shouldHave(Condition.text(message));
        return this;
    }

    @Step("Предупреждения нету")
    public OnlineBankPage errorNotExist() {
        error.shouldNotBe(Condition.exist);
        return this;
    }

    @Step("Жмем 'далее'")
    public OnlineBankPage pressSubmit() {
        submitButtom.shouldBe(Condition.exist).click();
        return this;
    }

    @Step("Вводим код из смс")
    public OnlineBankPage submitCode() {
        int SMS_CODE_SIZE = 4;
        smsCode.shouldBe(CollectionCondition.size(SMS_CODE_SIZE));
        return this;
    }

    @Step("Скачиваем 'условия доступа'")
    public OnlineBankPage accessTermsDownload() {
        PDF accessTermsPdf = null;
        try {
            accessTermsPdf = new PDF(accessTerms.download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(accessTermsPdf).containsExactText("Соглашение о пользовании сервисом «МТС Деньги»");
        return this;
    }

    @Step("Скачиваем 'политика конфиденциальности'")
    public OnlineBankPage privacyPolicyDownload() {
        PDF privacyPolicyPdf = null;
        try {
            privacyPolicyPdf = new PDF(privacyPolicy.download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(privacyPolicyPdf).containsExactText("Политика конфиденциальности сервиса «МТС Деньги»");
        return this;
    }

}
