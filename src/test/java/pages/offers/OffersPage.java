package pages.offers;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.*;

public class OffersPage {
    private final SelenideElement offersFromBaksCheckbox    = $x("//div[text()='Акции от банка']");
    private final ElementsCollection offersFromBanks        = $$("[class*=Offers__Wrapper] a");
    private final SelenideElement offersCheckboxCount       = $x("//input[@name='category[21]']/ancestor::label//span");


    @Step("Выбираем фильтр 'Акции банка'")
    public OffersPage offersFromBanksCheckboxOn() {
        offersFromBaksCheckbox.scrollTo().click();
        return this;
    }

    @Step("Сравниваем значения около чекбока 'Акции банка' и кол-во карточек с этими акциями")
    public OffersPage offersCountCheck() {
        int expectedSize = Integer.parseInt(offersCheckboxCount.text());
        offersFromBanks.shouldHave(CollectionCondition.size(expectedSize));
        return this;
    }
}
