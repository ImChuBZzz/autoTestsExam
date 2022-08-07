package pages.mortgage;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class MortgageItPage {

    //private final SelenideElement inputForm     = $x("//div[@id='form']");
    private final SelenideElement propertyPrice = $x("//div[@label='Стоимость недвижимости']/input");
    private final SelenideElement firstFee = $x("//div[@label='Первоначальный взнос']/input");
    private final SelenideElement creditTerm = $x("//div[@label='Срок кредита']/input");
    private final SelenideElement paymentTable = $x("//button//*[@data-testid='icon_baseX24/ic-calendar']");
    private final ElementsCollection years = $$x("//div[contains(@class, 'Year')]");


    @Step("Стоимость жилья: {0}")
    public MortgageItPage propertyPriceInput(String value) {
        propertyPrice.sendKeys(Keys.LEFT_CONTROL + "a");
        propertyPrice.sendKeys(Keys.BACK_SPACE);
        propertyPrice.scrollTo().setValue(value);
        return this;
    }

    @Step("Первоначальный взнос: {0}")
    public MortgageItPage firstFeeInput(String value) {
        firstFee.sendKeys(Keys.LEFT_CONTROL + "a");
        firstFee.sendKeys(Keys.BACK_SPACE);
        firstFee.setValue(value);
        return this;
    }

    @Step("Срок ипотеки: {0}")
    public MortgageItPage creditTermInput(String value) {
        creditTerm.sendKeys(Keys.LEFT_CONTROL + "a");
        creditTerm.sendKeys(Keys.BACK_SPACE);
        creditTerm.setValue(value);
        return this;
    }

    @Step("Переход в таблицу платежей")
    public MortgageItPage toPaymentTable() {
        paymentTable.shouldBe(Condition.exist).click();
        return this;
    }

    @Step("Срок ипотеки должен совпадать с кол-вом столбцов по годам")
    public MortgageItPage checkYearCount() {
        int expectedYears = Integer.parseInt(creditTerm.getValue().replaceAll("\\D", ""));
        years.shouldHave(CollectionCondition.size(expectedYears + 1));
        return this;
    }

}
