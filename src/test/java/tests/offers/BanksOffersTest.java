package tests.offers;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.offers.OffersPage;
import pages.StartPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class BanksOffersTest extends BaseTest {

    @Feature(value = "Акции и предложения")
    @Test
    @DisplayName("Проверка о совпадении кол-ва акции у чекбокса 'Акции' и кол-во карточек с предложениями")
    public void banksOffersCountCheck() {
        OffersPage offersPage = new StartPage()
                .openHomePage()
                .gotoOffers()
                .offersFromBanksCheckboxOn()
                .offersCountCheck();
    }
}
