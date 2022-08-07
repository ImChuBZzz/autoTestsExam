package pages.cards;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CardsPage {
    private final SelenideElement virtualCardTab = $x("//div[@data-testid='tabsbar']//a[contains(@href, 'virtual')]");
    private final ElementsCollection virtualCards = $$x("//h2");


    @Step("Выбираем виртуальную карту в меню")
    public CardsPage selectVirtualCards() {
        virtualCardTab.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Оформляем первую карту в списке")
    public CardOrder selectFirstCard() {
        virtualCards.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .first().click();
        return new CardOrder();
    }

}
