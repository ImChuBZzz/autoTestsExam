package tests.onlineBank;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.StartPage;
import pages.onlineBank.OnlineBankPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class OnlineBankTermsAndPolicyTest extends BaseTest {
    @Feature(value = "Онлайн банк")
    @Story(value = "Работа с документами")
    @DisplayName("Условия доступа")
    @Test
    public void expectedTermsPDF() {
        OnlineBankPage onlineBankPage = new StartPage()
                .openHomePage()
                .gotoOnlineBank()
                .accessTermsDownload();
    }

    /*@Feature(value = "Онлайн банк")
    @Story(value = "Работа с документами")
    @DisplayName("Политика кофиденциальности")
    @Test
    public void expectedPolicyPDF() {
        OnlineBankPage onlineBankPage = new StartPage()
                .openHomePage()
                .gotoOnlineBank()
                .privacyPolicyDownload();
    }*/
}
