package tests.offers;

import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.offers.OffersPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class BanksOffersTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Акции и предложения")
    @Test
    @DisplayName("Проверка о совпадении кол-ва акции у чекбокса 'Акции' и кол-во карточек с предложениями")
    public void banksOffersCountCheck() {
        OffersPage offersPage = new HomePage()
                .openHomePage()
                .gotoOffers()
                .offersFromBanksCheckboxOn()
                .offersCountCheck();
    }
}
