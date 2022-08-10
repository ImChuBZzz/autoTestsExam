package tests.mortgage;

import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.HomePage;
import pages.mortgage.MortgageItPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
@DisplayName("Проверка сроков ипотеки")
public class MortgagePaymentsGraphTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Ипотека")
    @Story(value = "Ипотека для ИТ")
    @Test
    @DisplayName("Проверка совпадения сроков ипотеки с годами в таблице платежей")
    public void shouldBeCorrectTimeline() {
        String propertyPrice = "10000000";
        String firstFee = "3000000";
        String creditTerm = "15";
        MortgageItPage mortgageItPage = new HomePage()
                .openHomePage()
                .gotoMortgageForIt()
                .propertyPriceInput(propertyPrice)
                .firstFeeInput(firstFee)
                .creditTermInput(creditTerm)
                .toPaymentTable()
                .checkYearCount();
    }
}
