import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


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
        return new UserCardApproved("1111 2222 3333 4444", yearGenerate, monthGenerate,
                faker.name().fullName(), cvc);
    }

    public static UserCardDeclined userDeclinedCard() {
        return new UserCardDeclined("5555 6666 7777 8888", yearGenerate, monthGenerate,
                faker.name().fullName(), cvc);

    }


    @Value
    public static class UserCardApproved {
        private String number;
        private String year;
        private String month;
        private String holder;
        private String cvc;
    }

    @Value
    public static class UserCardDeclined {
        private String number;
        private String year;
        private String month;
        private String holder;
        private String cvc;
    }

    private static String randomCVC() {
        int randomNumber = (int) (Math.random() * 9);
        int randomNumber1 = (int) (Math.random() * 9);
        int randomNumber2 = (int) (Math.random() * 9);
        return randomNumber + "" + randomNumber1 + "" + randomNumber2;
    }

    static String cvc = randomCVC();

    private static final RequestSpecification request = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    public void sendRequestForApprovedCard(UserCardApproved card) {
        given()
                .spec(request)
                .body(card)
                .when()
                .post("/api/v1/pay")
                .then()
                .statusCode(200)
                .body("status", equalTo("APPROVED"));
    }
    public void sendRequestForApprovedCard(UserCardDeclined card) {
        given()
                .spec(request)
                .body(card)
                .when()
                .post("/api/v1/pay")
                .then()
                .statusCode(200)
                .body("status", equalTo("APPROVED"));
    }
}
