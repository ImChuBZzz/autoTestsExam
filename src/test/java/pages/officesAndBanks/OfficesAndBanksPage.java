package pages.officesAndBanks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;



import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OfficesAndBanksPage {

    private final SelenideElement listButton        = $x("//div[@data-testid='tabsbar']//button/div[text()='Списком']");
    private final SelenideElement filtersField      = $x("//div[@class='styled__Container-sc-szata3-0 jhjBtN']");
    private final SelenideElement officeInput       = $x("//div[text()='Офисы МТС Банка']");
    private final SelenideElement shopsInput        = $x("//div[text()='Салон МТС']");
    private final SelenideElement terminalsInput    = $x("//div[text()='Терминалы']");
    private final ElementsCollection atmList        = $$x("//div[@class='styled__MainDataContainer-sc-egp5sf-0 evbWzI']");

    @Step("Переключаемся на фильтр 'Список'")
    public OfficesAndBanksPage clickOnListButton() {
        listButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("кликаем на 'Список'")
    public OfficesAndBanksPage filtersClick() {
        filtersField.click();
        return this;
    }

    @Step("Убираем чекбоксы у офисов, салонов и терминалов")
    public OfficesAndBanksPage setOnlyATM() {
        officeInput.scrollTo().click();
        shopsInput.click();
        terminalsInput.click();
        return this;
    }

    @Step("Список банкоматов не должнен быть пустым")
    public void ATMListSize() {
        atmList.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
