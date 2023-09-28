import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {
    MainPage mainPage = new MainPage();
    DataHelper dataHelper;

    @BeforeEach
    void setup() {
        open("http://localhost:8080/");
        mainPage.buttonReady.click();
    }

    @Test
    @DisplayName("Оплата по активной карте. Валидные данные")
    public void approvedCardTest() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.textCorrect.shouldBe(visible, Duration.ofSeconds(20)).
                shouldHave(Condition.exactText("Операция одобрена Банком."));
    }

/*    @Test
    public void declinedCardTest() {
        var user = DataHelper.userDeclinedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.textCorrect.shouldBe(visible, Duration.ofSeconds(10)).
                shouldHave(Condition.exactText("Карта заблокирована"));
    }*/
    @Test
    public void dataFormEmptyNumberCard() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromCard.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    public void dataFormEmptyMonth() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromMonth.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    @DisplayName("Оплата по активной карте. Валидные данные")
    public void dataFormEmptyYear() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromYear.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    @DisplayName("Оплата по активной карте. Валидные данные")
    public void dataFormEmptyName() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromName.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    @Test
    public void dataFormEmptyCvc() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromCvc.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    public void dataWrongCard() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue("123");
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorFormatFromCard.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    public void dataWrongMonth() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue("13");
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorExpiredCardMonth.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }
    @Test
    public void dataWrongYear() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue("88");
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorYear.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }
    @Test     //Баг репорт при дате и годе Неверно указан срок действия карты
    //
    public void dataExpiredCard() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue("22");
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorExpiredCardYear.shouldHave(Condition.exactText("Истёк срок действия карты"));
    }

    @Test  //Баг репорт имя на русской
    public void dataWrongNameLanguage() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue("Привет Привет");
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorYear.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test //Баг репорт имя цифрами
    public void dataWrongNameWriteNumbers() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue("123 123");
        mainPage.cardHolderCVC.setValue(user.getCvcCode());
        mainPage.buttonNext.click();
        mainPage.errorYear.shouldHave(Condition.exactText("Неверный формат"));
    }
    @Test
    public void dataWrongCvc() {
        var user = DataHelper.userApprovedCard();
        mainPage.cardHolderNumber.setValue(user.getCardNumber());
        mainPage.cardHolderMonthDate.setValue(user.getMonth());
        mainPage.cardHolderYearDate.setValue(user.getYear());
        mainPage.cardHolderName.setValue(user.getCardName());
        mainPage.cardHolderCVC.setValue("22");
        mainPage.buttonNext.click();
        mainPage.errorExpiredCvc.shouldHave(Condition.exactText("Неверный формат"));
    }

}
