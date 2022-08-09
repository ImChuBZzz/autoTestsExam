package pages.smallBuiness;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import java.io.IOException;


import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$x;

public class SmallBusinessAccountPage {
    private final SelenideElement tariffPdfLink = $x("//div[2]/a[@rel='noopener noreferrer']");
    private final SelenideElement currencyTransferPdfLink = $x("//div[1]/a[@rel='noopener noreferrer']");


    @Step("Проверяем что это файл pdf про тарифы")
    public SmallBusinessAccountPage checkTariffPDFLink() {
        PDF tariffPdf = null;
        try {
            tariffPdf = new PDF(tariffPdfLink.scrollIntoView(true).download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(tariffPdf).containsExactText("Изменения тарифов");
        return this;
    }

    @Step("Проверяем что это именно файл pdf про перевод валюты")
    public SmallBusinessAccountPage currencyTransferPDFLink() {
        PDF currencyPdf = null;
        try {
            currencyPdf = new PDF(currencyTransferPdfLink.scrollIntoView(true).download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(currencyPdf).containsExactText("Правила оформления Поручений на перевод иностранной валюты");
        return this;
    }
}
