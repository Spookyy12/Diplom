import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiHelper {
    DataHelper dataHelper = new DataHelper();
    private static final RequestSpecification request = new RequestSpecBuilder()
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    public static String  sendRequest() {
        var user = DataHelper.userApprovedCard();
        given()
                .spec(request)
                .body(user)
                .when()
                .post("http://localhost:8080/api/v1/pay")
                .then()
                .body("status", equalTo("DECLIN89ED"));
    return new String();


    }


}
