package ru.netology.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Дашбоард")
public class DashboardPage extends AkitaPage {
    @FindBy(css = "[data-test-id=dashboard]")
    private SelenideElement heading;

    @FindBy(css = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']")
    @Name("Первая карта")
    private SelenideElement card1;
    @FindBy(css = "[data-test-id=action-deposit]")
    @Name("Пополнить")
    private SelenideElement addButton;

    public TransferPage returnTransferForCard1() {
        //System.out.println(card1.getText());
        addButton.click();
                return Selenide.page(TransferPage.class);
    }

    public int getCurrentBalanceForCard1() {
        String text = card1.getText().substring(29);
        text = text.substring(0, text.indexOf(" р."));
        int currentBalance = Integer.valueOf(text);
        return currentBalance;
    }
}
