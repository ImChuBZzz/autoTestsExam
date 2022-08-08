package pages.deposit;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.*;

public class DepositPage {

    private final ElementsCollection depositInfo    = $$x("//h4/preceding-sibling::div[preceding-sibling::h4//ul]");
    //private final ElementsCollection depositInfo    = $$x("//h3");
    private final SelenideElement depositInput      = $x("//div[@label='Сумма вклада']/input");
    private final SelenideElement termInput         = $x("//div[@label='Срок вклада']/input");
    private final SelenideElement minDepositValue   = $x("//li[1][contains(@class, 'Border-sc')]");
    private final SelenideElement maxDepositValue   = $x("//li[2][contains(@class, 'Border-sc')]");
    private final SelenideElement minMonthValue     = $x("//div[@class='rc-slider-mark']/span[1]");
    private final SelenideElement maxMonthValue     = $x("//div[@class='rc-slider-mark']/span[last()]");

    @Step("Сумма депозита не превышает пределы [1_000 - 50_000_00] рублей")
    public DepositPage checkDepositValue(Integer value) {
        depositInput.sendKeys(Keys.LEFT_CONTROL + "a");
        depositInput.sendKeys(Keys.BACK_SPACE);
        depositInput.setValue(value.toString()).sendKeys(Keys.TAB);
        int minValue = Integer.parseInt(minDepositValue.text().replaceAll("\\D", ""));
        int maxValue = Integer.parseInt(maxDepositValue.text().replaceAll("\\D", ""));
        if(value < minValue) {
            Assert.assertEquals(Integer.parseInt(depositInput.getValue()), minValue);
        }
        else if (value > maxValue) {
            Assert.assertEquals(Integer.parseInt(depositInput.getValue()), maxValue);
        }
        return this;
    }

    @Step("Срок вклада не прывышает пределы [1 - 24] месяца")
    public DepositPage checkTermValue(Integer value) {
        termInput.sendKeys(Keys.LEFT_CONTROL + "a");
        termInput.sendKeys(Keys.BACK_SPACE);
        termInput.setValue(value.toString()).sendKeys(Keys.TAB);
        int minValue = Integer.parseInt(minMonthValue.text().replaceAll("\\D", ""));
        int maxValue = Integer.parseInt(maxMonthValue.text().replaceAll("\\D", ""));
        if (value > maxValue) {
            Assert.assertEquals(Integer.parseInt(termInput.getValue().replaceAll("\\D", "")), maxValue);
        }
        return this;
    }


}
