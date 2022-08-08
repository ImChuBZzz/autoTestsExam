package tests.cards;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.StartPage;
import pages.cards.CardOrder;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class VirtualCardOrderTest extends BaseTest {

    @Feature(value = "Карты")
    @Story(value = "Виртуальная карта")
    @Test
    @DisplayName("Подтверждение смс кода")
    public void isSmsCodeReadyToInput() {
        String phoneExample = "9169169169";
        CardOrder cardOrder = new StartPage()
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
    @DisplayName("Ошибка ввода номера телефона")
    public void emptyPhoneRequest() {
        String error = "Введите верный номер телефона";
        CardOrder cardOrder = new StartPage()
                .openHomePage()
                .gotoCards()
                .selectVirtualCards()
                .selectFirstCard()
                .inputEmptyPhone()
                .sendCode()
                .warning(error);
    }
}
