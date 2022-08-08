package tests.officesAndBanks;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.officesAndBanks.OfficesAndBanksPage;
import pages.StartPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class ATMCheckoutTest extends BaseTest {

    @Feature(value = "Офисы и банкоматы")
    @Story(value = "Проверяем наличие доступных банкоматов")
    @Test
    public void atbNotEmptyCheck() {
        OfficesAndBanksPage officesAndBanksPage = new StartPage()
                .openHomePage()
                .gotoOfficesAndBanks()
                .loading()
                .clickOnListButton()
                .filtersClick()
                .setOnlyATM()
                .filtersClick();
        officesAndBanksPage.ATMListSize();
    }
}
