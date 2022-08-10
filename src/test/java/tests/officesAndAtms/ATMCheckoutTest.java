package tests.officesAndAtms;


import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.officesAndAtms.OfficesAndAtmsPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
@DisplayName("Проверка списка банкоматов в Москве")
public class ATMCheckoutTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Офисы и банкоматы")
    @Test
    @DisplayName("Проверяем наличие доступных банкоматов")
    public void atbNotEmptyCheck() {
        OfficesAndAtmsPage officesAndAtmsPage = new HomePage()
                .openHomePage()
                .gotoOfficesAndBanks()
                .loading()
                .clickOnListButton()
                .filtersClick()
                .offices()
                .shops()
                .terminals()
                .filtersClick();
        officesAndAtmsPage.ATMListSize();
    }
}
