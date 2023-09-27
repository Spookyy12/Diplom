import com.github.javafaker.Faker;
import lombok.Value;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    DataHelper() {
    }

    private static final Faker faker = new Faker(new Locale("en"));
    static SimpleDateFormat sdf = new SimpleDateFormat("MM");


        public static UserCard getAuthInfo() {
            return new UserCard(faker.finance().creditCard(), sdf.format(faker.date().birthday()), faker.random().nextInt(23, 28), faker.random().nextInt(100, 999), faker.name().fullName());
        }

        @Value
        public static class UserCard {
            private String numberCard;
            private String month;
            private int year;
            private int numberCvc;
            private String cardName;

        }

    }
