package tests.deposit;

import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.HomePage;
import pages.deposit.DepositPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
@DisplayName("Не выходим за допустимые значения депозита и срока")
public class DepositPositiveValuesTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Вклады")
    @Test
    @DisplayName("Проверка допустимых значений суммы вклада")
    public void checkDepositValue() {
        Integer depositValue = 1_000_0;
        DepositPage depositPage = new HomePage()
                .openHomePage()
                .gotoDeposits()
                .checkDepositValue(depositValue);
    }

    @Feature(value = "Вклады")
    @Test
    @DisplayName("Проверка допустимых значений сроков вклада")
    public void checkTermValue() {
        Integer termValue = 12;
        DepositPage depositPage = new HomePage()
                .openHomePage()
                .gotoDeposits()
                .checkTermValue(termValue);
    }
}
