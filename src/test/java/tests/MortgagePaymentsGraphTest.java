package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.StartPage;
import pages.mortgage.MortgageItPage;

@Owner("автор - Александр Черняев")
public class MortgagePaymentsGraphTest extends BaseTest{
    @Feature(value = "Ипотека")
    @Story(value = "Проверка срока ипотеки и кол-во вкладок по годам в таблице платежей")
    @Test
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
