import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import lombok.Value;


import java.security.Security;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    DataHelper() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    private static String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern((pattern)));
    }

    static String monthGenerate = generateDate(1, "MM");
    static String yearGenerate = generateDate(0, "yy");

    public static UserCardApproved userApprovedCard() {
        return new UserCardApproved(cvc, "1111 2222 3333 4444", monthGenerate,
                yearGenerate, faker.name().fullName());
    }

    public static UserCardApproved userDeclinedCard() {
        return new UserCardApproved(cvc, "5555 6666 7777 8888", monthGenerate,
                yearGenerate, faker.name().fullName());
    }

    @Value
    public static class UserCardApproved {
        private String cvcCode;
        private String cardNumber;
        private String month;
        private String year;
        private String cardName;
    }

    @Value
    public static class UserCardDeclined {
        private String cvcCode;
        private String cardNumber;
        private String month;
        private String year;
        private String cardName;
    }

    private static String randomCVC() {
        int randomNumber = (int) (Math.random() * 9);
        int randomNumber1 = (int) (Math.random() * 9);
        int randomNumber2 = (int) (Math.random() * 9);
        return randomNumber + "" + randomNumber1 + "" + randomNumber2;
    }

    static String cvc = randomCVC();

}
