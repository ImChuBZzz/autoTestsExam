package tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.officesAndBanks.OfficesAndBanksPage;
import pages.StartPage;

@Owner("автор - Александр Черняев")
public class ATMCheckoutTest extends BaseTest{

    @Feature(value = "Офисы и банкоматы")
    @Story(value = "Проверяем наличие доступных банкоматов")
    @Test
    public void atbNotEmptyCheck() {
        OfficesAndBanksPage officesAndBanksPage = new StartPage()
                .openHomePage()
                .gotoOfficesAndBanks()
                .clickOnListButton()
                .filtersClick()
                .setOnlyATM()
                .filtersClick();
        officesAndBanksPage.ATMListSize();
    }
}
