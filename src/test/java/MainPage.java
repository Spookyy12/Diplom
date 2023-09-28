import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement buttonReady = $x("//*[@id='root']/div/button[1]/span");
    private SelenideElement cardHolderNumber = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    private SelenideElement cardHolderMonthDate = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    private SelenideElement cardHolderYearDate = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    private SelenideElement cardHolderName = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement cardHolderCVC = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private SelenideElement buttonNext = $x("//*[@id=\"root\"]/div/form/fieldset/div[4]/button/span/span");
    private SelenideElement textCorrect = $(".notification__title");


    public String validCardForString() {
        buttonReady.click();
        cardHolderNumber.setValue("1111222233334444");
        cardHolderMonthDate.setValue(String.valueOf(DataHelper.getAuthInfo().getMonth()));
        cardHolderYearDate.setValue(String.valueOf(DataHelper.getAuthInfo().getYear()));
        cardHolderName.setValue(String.valueOf(DataHelper.getAuthInfo().getCardName()));
        cardHolderCVC.setValue(String.valueOf(DataHelper.getAuthInfo().getNumberCvc()));
        buttonNext.click();
        textCorrect.shouldBe(visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Успешно"));
        return new String();
    }


}
