package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.StartPage;
import pages.deposit.DepositPage;

@Owner("автор - Александр Черняев")
public class DepositPositiveValuesTest extends BaseTest{

    private final Integer depositeValue = 100_000_00;
    private final Integer termValue     = 120;

    @Feature(value = "Вклады")
    @Story(value = "Проверка допустимых значений суммы вклада")
    @Test
    public void checkDepositValue() {
        DepositPage depositPage = new StartPage()
                .openHomePage()
                .gotoDeposits()
                .checkDepositValue(depositeValue);
    }
    @Feature(value = "Вклады")
    @Story(value = "Проверка допустимых значений сроков вклада")
    @Test
    public void checkTermValue() {
        DepositPage depositPage = new StartPage()
                .openHomePage()
                .gotoDeposits()
                .checkTermValue(termValue);
    }
}
