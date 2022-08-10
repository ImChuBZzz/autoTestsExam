package tests.cards;


import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import pages.HomePage;
import pages.cards.CardOrder;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class VirtualCardOrderTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Карты")
    @Story(value = "Виртуальная карта")
    @Test
    @DisplayName("Подтверждение смс кода")
    public void isSmsCodeReadyToInput() {
        String phoneExample = "9169169169";
        CardOrder cardOrder = new HomePage()
                .openHomePage()
                .gotoCards()
                .selectVirtualCards()
                .selectFirstCard()
                .inputPhone(phoneExample)
                .ok()
                .sendCode()
                .submitCode();
    }

    @Feature(value = "Карты")
    @Story(value = "Виртуальная карта")
    @Test
    @DisplayName("Не вводим номер и просто жмем 'оформить карту'")
    public void emptyPhoneRequest() {
        String error = "Введите верный номер телефона";
        CardOrder cardOrder = new HomePage()
                .openHomePage()
                .gotoCards()
                .selectVirtualCards()
                .selectFirstCard()
                .inputEmptyPhone()
                .sendCode()
                .warning(error);
    }

    @Feature(value = "Карты")
    @Story(value = "Виртуальная карта")
    @Test
    @DisplayName("Вводим не полный номер телефона")
    public void incorrectPhoneRequest() {
        String error = "Введите верный номер телефона";
        String phoneExample = "916916916";
        CardOrder cardOrder = new HomePage()
                .openHomePage()
                .gotoCards()
                .selectVirtualCards()
                .selectFirstCard()
                .inputIncorrectPhone(phoneExample)
                .sendCode()
                .warning(error);
    }
}
