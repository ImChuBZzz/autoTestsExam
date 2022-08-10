package tests.smallBusiness;


import helpers.RetryRule;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessPage;
import pages.HomePage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class SmallBusinessSocialsTest extends BaseTest {

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    @DisplayName("Телеграмм")
    public void tgUrlTest() {
        String tgUrl = "https://t.me/mts_tb";
        SmallBusinessPage smallBusinessPage = new HomePage()
                .openHomePage()
                .gotoSmallBuisness()
                .tgUrl()
                .checkTgUrl(tgUrl);
    }

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    @DisplayName("вКонтакте")
    public void vkUrlTest() {
        String vkUrl = "https://vk.com/mts_tb";
        SmallBusinessPage smallBusinessPage = new HomePage()
                .openHomePage()
                .gotoSmallBuisness()
                .vkUrl()
                .checkVkUrl(vkUrl);
    }

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    @DisplayName("Одноклассники")
    public void okUrlTest() {
        String okUrl = "https://ok.ru/mts.business";
        SmallBusinessPage smallBusinessPage = new HomePage()
                .openHomePage()
                .gotoSmallBuisness()
                .okUrl()
                .checkOkUrl(okUrl);
    }
}
