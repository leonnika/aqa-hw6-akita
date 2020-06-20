package ru.netology.step;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import lombok.val;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.netology.data.DataHelper;
import ru.netology.page.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.alfabank.tests.core.helpers.PropertyLoader.loadProperty;

public class TemplateSteps {
    private final AkitaScenario scenario = AkitaScenario.getInstance();

    @Пусть("^пользователь залогинен с именем \"([^\"]*)\" и паролем \"([^\"]*)\"$")
    public void loginWithNameAndPassword(String login, String password) {
        val loginUrl = loadProperty("loginUrl");
        open(loginUrl);
        scenario.setCurrentPage(page(LoginPage.class));
        val loginPage = (LoginPage) scenario.getCurrentPage().appeared();
        val authInfo = new DataHelper.AuthInfo(login, password);
        scenario.setCurrentPage(loginPage.validLogin(authInfo));
        val verificationPage = (VerificationPage) scenario.getCurrentPage().appeared();
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        scenario.setCurrentPage(verificationPage.validVerify(verificationCode));
    }

   @Когда("^он переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы")
   //public void transferMoney(int amount, String cardFrom, String cardIn) {
       public void transferMoney() {
       val dashboardPage = (DashboardPage) scenario.getCurrentPage().appeared();
       scenario.setCurrentPage(dashboardPage.returnTransferForCard1());

       val transferPage =(TransferPage) scenario.getCurrentPage().appeared();

       scenario.setCurrentPage(transferPage.TransferFromCard02Amount5000(5000));
   }

    @Тогда("^баланс его 1 карты из списка на главной странице должен стать 15 000 рублей")
 public void checkBalance(){
        val dashboardPageNew = (DashboardPage) scenario.getCurrentPage().appeared();
        int currentBalance = dashboardPageNew.getCurrentBalanceForCard1();
        assertEquals(15000, currentBalance );
   }
}