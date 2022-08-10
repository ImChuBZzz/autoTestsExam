package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.cards.CardsPage;
import pages.deposit.DepositPage;
import pages.mortgage.MortgageItPage;
import pages.offers.OffersPage;
import pages.officesAndAtms.OfficesAndAtmsPage;
import pages.onlineBank.OnlineBankPage;
import pages.smallBuiness.SmallBusinessPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement officesAndBanks = $x("//div[@id='top']//a[@data-testid='link']");
    private final SelenideElement offers = $x("//a[@href='/offers']");
    private final SelenideElement smallBusiness = $x("//a[@href='/malomu-biznesu/']");
    private final SelenideElement cardsTab = $x("//div[1]/a[@href='/chastnim-licam/karti/']");
    private final SelenideElement mortgage = $x("//div[contains(@class, 'Menu')]/a[@href='/chastnim-licam/ipoteka/']");
    private final SelenideElement mortgageIt = $x("//a[@href='/chastnim-licam/ipoteka/it/']");
    private final SelenideElement deposits = $x("//ul//a[@href='/chastnim-licam/vkladi/']");
    private final SelenideElement onlineBank = $x("//div[@id='bottom']");

    @Step("Открываем https://www.mtsbank.ru")
    public HomePage openHomePage() {
        Selenide.open(baseUrl);
        return this;
    }

    @Step("Переход на вкладку 'Офисы и банкоматы'")
    public OfficesAndAtmsPage gotoOfficesAndBanks() {
        officesAndBanks.shouldBe(Condition.visible).click();
        return new OfficesAndAtmsPage();
    }

    @Step("Переход на вкладку 'Акции и предложения'")
    public OffersPage gotoOffers() {
        offers.shouldBe(Condition.visible).click();
        return new OffersPage();
    }

    @Step("Переход на вкладку 'Малый бизнес и ИП'")
    public SmallBusinessPage gotoSmallBuisness() {
        smallBusiness.shouldBe(Condition.visible).click();
        return new SmallBusinessPage();
    }

    @Step("Переход на вкладку 'Карты'")
    public CardsPage gotoCards() {
        cardsTab.shouldBe(Condition.visible).click();
        return new CardsPage();
    }

    @Step("Переход на вкладку 'Ипотека'")
    public MortgageItPage gotoMortgageForIt() {
        mortgage.shouldBe(Condition.visible).hover();
        mortgageIt.shouldBe(Condition.visible).click();
        return new MortgageItPage();
    }

    @Step("Переход на вкладку 'Вклады'")
    public DepositPage gotoDeposits() {
        deposits.scrollTo().click();
        return new DepositPage();
    }

    @Step("Переход в онлайн банк")
    public OnlineBankPage gotoOnlineBank() {
        onlineBank.shouldBe(Condition.visible).click();
        return new OnlineBankPage();
    }

}
