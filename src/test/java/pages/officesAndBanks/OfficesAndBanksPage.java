package pages.officesAndBanks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OfficesAndBanksPage {

    private final SelenideElement listButton = $x("//div[@data-testid='tabsbar']//button[2]");
    private final SelenideElement filtersField = $x("//div[@class='styled__Container-sc-szata3-0 jhjBtN']");
    private final SelenideElement officeInput = $x("//div[text()='Офисы МТС Банка']");
    private final SelenideElement shopsInput = $x("//div[text()='Салон МТС']");
    private final SelenideElement terminalsInput = $x("//div[text()='Терминалы']");
    private final SelenideElement spinner = $x("//div[@data-testid='heading']");
    private final ElementsCollection atmList = $$x("//div[@class='styled__MainDataContainer-sc-egp5sf-0 evbWzI']");

    @Step("Переключаемся на фильтр 'Список'")
    public OfficesAndBanksPage clickOnListButton() {
        listButton.shouldBe(Condition.exist, Duration.ofSeconds(30)).click();
        return this;
    }

    @Step("Ждём-с прогрузку....")
    public OfficesAndBanksPage loading() {
        spinner.shouldNotBe(Condition.exist);
        return this;
    }

    @Step("кликаем на 'Список'")
    public OfficesAndBanksPage filtersClick() {
        filtersField.shouldBe(Condition.exist, Duration.ofSeconds(30)).click();
        return this;
    }

    @Step("Кликаем на 'офисы'")
    public OfficesAndBanksPage offices() {
        officeInput.scrollTo().click();
        return this;
    }

    @Step("Кликаем на 'салоны'")
    public OfficesAndBanksPage shops() {
        shopsInput.click();
        return this;
    }

    @Step("Кликаем на 'терминалы'")
    public OfficesAndBanksPage terminals() {
        terminalsInput.click();
        return this;
    }

    @Step("Список банкоматов не должнен быть пустым")
    public void ATMListSize() {
        atmList.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
