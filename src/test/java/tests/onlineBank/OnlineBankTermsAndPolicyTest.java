package tests.onlineBank;

import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import pages.HomePage;
import pages.onlineBank.OnlineBankPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
@DisplayName("Проверка файлов по ссылкам 'условия доступа' и 'политика конфиденциальности'")
public class OnlineBankTermsAndPolicyTest extends BaseTest {
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Онлайн банк")
    @Story(value = "Работа с документами")
    @DisplayName("Условия доступа")
    @Test
    public void expectedTermsPDF() {
        OnlineBankPage onlineBankPage = new HomePage()
                .openHomePage()
                .gotoOnlineBank()
                .accessTermsDownload();
    }

    @Feature(value = "Онлайн банк")
    @Story(value = "Работа с документами")
    @DisplayName("Политика кофиденциальности")
    @Test
    @Ignore("pdf readonly и не получается взять заголовок")
    public void expectedPolicyPDF() {
        OnlineBankPage onlineBankPage = new HomePage()
                .openHomePage()
                .gotoOnlineBank()
                .privacyPolicyDownload();
    }
}
