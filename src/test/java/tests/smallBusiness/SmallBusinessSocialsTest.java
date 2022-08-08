package tests.smallBusiness;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessPage;
import pages.StartPage;
import tests.BaseTest;

@Owner("автор - Александр Черняев")
public class SmallBusinessSocialsTest extends BaseTest {

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void tgUrlTest() {
        String tgUrl = "https://t.me/mts_tb";
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .tgUrl()
                .checkTgUrl(tgUrl);
    }

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void vkUrlTest() {
        String vkUrl = "https://vk.com/mts_tb";
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .vkUrl()
                .checkVkUrl(vkUrl);
    }

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void okUrlTest() {
        String okUrl = "https://ok.ru/mts.business";
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .okUrl()
                .checkOkUrl(okUrl);
    }
}
