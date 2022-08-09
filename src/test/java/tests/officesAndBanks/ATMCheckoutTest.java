package tests.officesAndBanks;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.officesAndBanks.OfficesAndBanksPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class ATMCheckoutTest extends BaseTest {

    @Feature(value = "Офисы и банкоматы")
    @Test
    @DisplayName("Проверяем наличие доступных банкоматов")
    public void atbNotEmptyCheck() {
        OfficesAndBanksPage officesAndBanksPage = new HomePage()
                .openHomePage()
                .gotoOfficesAndBanks()
                .loading()
                .clickOnListButton()
                .filtersClick()
                .offices()
                .shops()
                .terminals()
                .filtersClick();
        officesAndBanksPage.ATMListSize();
    }
}
