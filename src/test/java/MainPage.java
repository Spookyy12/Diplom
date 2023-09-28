import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {


    public SelenideElement buttonReady = $x("//*[@id='root']/div/button[1]/span");
    public SelenideElement cardHolderNumber = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    public SelenideElement cardHolderMonthDate = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    public SelenideElement cardHolderYearDate = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    public SelenideElement cardHolderName = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    public SelenideElement cardHolderCVC = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    public SelenideElement buttonNext = $x("//*[@id=\"root\"]/div/form/fieldset/div[4]/button/span/span");
    public SelenideElement textCorrect = $(".notification__content");
    public SelenideElement errorFormatFromCard = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[3]");
    public SelenideElement errorFormatFromMonth = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]");
    public SelenideElement errorFormatFromYear = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]");
    public SelenideElement errorFormatFromName = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[3]");
    public SelenideElement errorFormatFromCvc = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]");
    public SelenideElement errorYear = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]");
    public SelenideElement errorExpiredCardYear = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]");
    public SelenideElement errorExpiredCardMonth = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]");
    public SelenideElement errorExpiredCvc = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]\n");

    //*[@id="root"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]
    //*[@id="root"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]
    /*public void cardNumber(String card){
        buttonReady.click();
        cardHolderNumber.setValue(card);
    }
     public void validCard() {
        buttonReady.click();
        cardHolderNumber.setValue("1111222233334444");
        cardHolderMonthDate.setValue(String.valueOf(DataHelper.getAuthInfo().getMonth()));
        cardHolderYearDate.setValue(String.valueOf(DataHelper.getAuthInfo().getYear()));
        cardHolderName.setValue(String.valueOf(DataHelper.getAuthInfo().getCardName()));
        cardHolderCVC.setValue(DataHelper.randomCVC());
        buttonNext.click();
        textCorrect.shouldBe(visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Операция одобрена Банком."));

    }
    public String declinedCard() {
        buttonReady.click();
        cardHolderNumber.setValue("5555666677778888");
        cardHolderMonthDate.setValue(String.valueOf(DataHelper.getAuthInfo().getMonth()));
        cardHolderYearDate.setValue(String.valueOf(DataHelper.getAuthInfo().getYear()));
        cardHolderName.setValue(String.valueOf(DataHelper.getAuthInfo().getCardName()));
        cardHolderCVC.setValue(DataHelper.randomCVC()+DataHelper.randomCVC()+DataHelper.randomCVC());
        buttonNext.click();
        textCorrect.shouldBe(visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Карта заблокирована"));
        return new String();
    }
    public String emptyCardForm() {
        buttonReady.click();
        cardHolderMonthDate.setValue(String.valueOf(DataHelper.getAuthInfo().getMonth()));
        cardHolderYearDate.setValue(String.valueOf(DataHelper.getAuthInfo().getYear()));
        cardHolderName.setValue(String.valueOf(DataHelper.getAuthInfo().getCardName()));
        cardHolderCVC.setValue(DataHelper.randomCVC()+DataHelper.randomCVC()+DataHelper.randomCVC());
        buttonNext.click();
        errorFormat.shouldHave(Condition.exactText("Неверный формат"));
        return new String();
    }
    public String emptyCardForm() {
        buttonReady.click();
        cardHolderMonthDate.setValue(String.valueOf(DataHelper.getAuthInfo().getMonth()));
        cardHolderYearDate.setValue(String.valueOf(DataHelper.getAuthInfo().getYear()));
        cardHolderName.setValue(String.valueOf(DataHelper.getAuthInfo().getCardName()));
        cardHolderCVC.setValue(DataHelper.randomCVC()+DataHelper.randomCVC()+DataHelper.randomCVC());
        buttonNext.click();
        errorFormat.shouldHave(Condition.exactText("Неверный формат"));
        return new String();
    }
*/
}
