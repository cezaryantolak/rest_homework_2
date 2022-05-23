package specifications;

import helpers.HelpfulMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static java.lang.Long.parseLong;

public class SpecificationsGenerator extends HelpfulMethods {

    public RequestSpecification generateRequestSpecification() {

        RequestSpecification requestSpecification = given()
                .log()
                .all()
                .header("name", System.getProperty("name"))
                .header("age", System.getProperty("age"))
                .param("q", System.getProperty("city"))
                .param("appid", System.getProperty("token"));

        return  requestSpecification;
    }

    public ResponseSpecification generateResponseSpecification() {

        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.time(Matchers.lessThan(parseLong(System.getProperty("responseTime"))));
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(getInteger(System.getProperty("successResponseCode")));

        return responseSpecification;
    }




}
