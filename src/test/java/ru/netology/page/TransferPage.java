package ru.netology.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Name("Перевод")
public class TransferPage extends AkitaPage {
    @FindBy(css = "[data-test-id=amount] input")
    @Name("Сумма перевода")
    private SelenideElement amountTransfer;
    @FindBy(css = "[data-test-id=from] input")
    @Name("Карта с которой переводим")
    private SelenideElement cardFrom;
    @FindBy(css = "[data-test-id='action-transfer']")
    @Name("Пополнить")
    private SelenideElement transferButton;
 //   @FindBy(css = "[data-test-id=error-notification]")
//    @Name("Ошибка")
 //  private SelenideElement errorTransfer;

    public DashboardPage TransferFromCard02Amount5000(int amount) {
        amountTransfer.setValue("5000");
        cardFrom.setValue("5559 0000 0000 0002");
        transferButton.click();
      //  errorTransfer.shouldNotBe(visible);
        return Selenide.page(DashboardPage.class);
    }

}
