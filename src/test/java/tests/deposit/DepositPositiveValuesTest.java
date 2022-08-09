package tests.deposit;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.deposit.DepositPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class DepositPositiveValuesTest extends BaseTest {

    @Feature(value = "Вклады")
    @Test
    @DisplayName("Проверка допустимых значений суммы вклада")
    public void checkDepositValue() {
        Integer depositValue = 100_000_0;
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
