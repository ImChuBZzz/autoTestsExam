package tests.mortgage;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.StartPage;
import pages.mortgage.MortgageItPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class MortgagePaymentsGraphTest extends BaseTest {
    @Feature(value = "Ипотека")
    @Story(value = "Ипотека для ИТ")
    @Test
    @DisplayName("Проверка совпадения сроков ипотеки с годами в таблице платежей")
    public void shouldBeCorrectTimeline() {
        String propertyPrice = "10000000";
        String firstFee = "3000000";
        String creditTerm = "15";
        MortgageItPage mortgageItPage = new StartPage()
                .openHomePage()
                .gotoMortgageForIt()
                .propertyPriceInput(propertyPrice)
                .firstFeeInput(firstFee)
                .creditTermInput(creditTerm)
                .toPaymentTable()
                .checkYearCount();
    }
}
