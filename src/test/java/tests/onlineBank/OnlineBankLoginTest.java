package tests.onlineBank;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.onlineBank.OnlineBankPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class OnlineBankLoginTest extends BaseTest {

    @Feature(value = "Онлайн банк")
    @Story(value = "Авторизация успешная")
    @Test
    @DisplayName("Подтверждаем код")
    public void correctPhoneNumberInput() {
        String CORRECT_PHONE = "9169169169";
        OnlineBankPage login = new HomePage()
                .openHomePage()
                .gotoOnlineBank()
                .inputCorrectPhone(CORRECT_PHONE)
                .pressSubmit()
                .errorNotExist()
                .submitCode();
    }

    @Feature(value = "Онлайн банк")
    @Story(value = "Авторизация неуспешная")
    @Test
    @DisplayName("Неправильный номер телефона")
    public void incorrectPhoneNumberInput() {
        String INCORRECT_PHONE = "1111111111";
        String INCORRECT_PHONE_ERROR = "Неправильный номер телефона";
        OnlineBankPage login = new HomePage()
                .openHomePage()
                .gotoOnlineBank()
                .inputIncorrectPhone(INCORRECT_PHONE)
                .pressSubmit()
                .errorExist(INCORRECT_PHONE_ERROR);

    }

    @Feature(value = "Онлайн банк")
    @Story(value = "Авторизация неуспешная")
    @Test
    @DisplayName("Пустой телефон")
    public void emptyPhoneNumberInput() {
        String EMPTY_PHONE_ERROR = "Номер телефона должен содержать 10 цифр, например, +7 912 345-67-89";
        OnlineBankPage login = new HomePage()
                .openHomePage()
                .gotoOnlineBank()
                .inputEmptyPhone()
                .pressSubmit()
                .errorExist(EMPTY_PHONE_ERROR);
    }
}
