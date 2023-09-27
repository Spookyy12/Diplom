import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {
    MainPage mainPage = new MainPage();
    @BeforeEach
    void setup (){
        open("http://localhost:8080/");
    }

    @Test
    public void validTest(){


        mainPage.validCardForString();

    }
}
