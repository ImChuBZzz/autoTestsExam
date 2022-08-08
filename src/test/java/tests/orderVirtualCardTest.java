package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.StartPage;
import pages.cards.CardOrder;

@Owner("автор - Александр Черняев")
public class orderVirtualCardTest extends BaseTest{

    @Feature(value = "Карты")
    @Story(value = "Виртуальная карта")
    @Test
    public void isSmsCodeReadyToInput() {
        String phoneExample = "9169169169";
        CardOrder cardOrder = new StartPage()
                .openHomePage()
                .gotoCards()
                .selectVirtualCards()
                .selectFirstCard()
                .visibleSmsCodeInput(phoneExample);
    }
}
