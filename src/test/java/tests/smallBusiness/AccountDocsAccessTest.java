package tests.smallBusiness;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Ignore;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessAccountPage;
import pages.StartPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class AccountDocsAccessTest extends BaseTest {

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Расчетный счет")
    @Test
    public void tariffPDFAccessTest() {
        SmallBusinessAccountPage accountPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .gotoAccount()
                .checkTariffPDFLink();
    }
    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Расчетный счет")
    @Test
    public void currencyTransferAccessTest() {
        SmallBusinessAccountPage accountPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .gotoAccount()
                .currencyTransferPDFLink();
    }

}
