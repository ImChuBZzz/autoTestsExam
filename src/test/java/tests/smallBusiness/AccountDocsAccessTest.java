package tests.smallBusiness;

import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessAccountPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
@DisplayName("Проверка документа 'Правила оформления Поручений на перевод иностранной валюты'")
public class AccountDocsAccessTest extends BaseTest {

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Расчетный счет")
    @Ignore("этот документ убрали с сайта 08.08.2022")
    @Test
    @DisplayName("Документы об изменении тарифов")
    public void tariffPDFAccessTest() {
        SmallBusinessAccountPage accountPage = new HomePage()
                .openHomePage()
                .gotoSmallBuisness()
                .gotoAccount()
                .checkTariffPDFLink();
    }
    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Расчетный счет")
    @Test
    @DisplayName("Документы о поручениях на перевод")
    public void currencyTransferAccessTest() {
        SmallBusinessAccountPage accountPage = new HomePage()
                .openHomePage()
                .gotoSmallBuisness()
                .gotoAccount()
                .currencyTransferPDFLink();
    }

}
