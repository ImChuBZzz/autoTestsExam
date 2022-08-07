package tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.smallBuiness.SmallBusinessPage;
import pages.StartPage;

@Owner("автор - Александр Черняев")
public class SmallBusinessSocialsTest extends BaseTest {

    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void tgUrlTest() {
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .checkTGUrl();
    }
    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void vkUrlTest() {
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .checkVKUrl();
    }
    @Feature(value = "Малый бизнес и ИП")
    @Story(value = "Проверка соцсетей")
    @Test
    public void okUrlTest() {
        SmallBusinessPage smallBusinessPage = new StartPage()
                .openHomePage()
                .gotoSmallBuisness()
                .checkOKUrl();
    }
}
