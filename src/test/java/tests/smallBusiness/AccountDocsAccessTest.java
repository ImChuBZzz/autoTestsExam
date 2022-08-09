package tests.smallBusiness;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessAccountPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class AccountDocsAccessTest extends BaseTest {

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Расчетный счет")
    @Ignore
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
