package base;

import configuration.AppProperties;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import specifications.SpecificationsGenerator;

public class BaseTest extends SpecificationsGenerator {

    private static Logger log = LoggerFactory.getLogger("BaseTest.class");
    private static AppProperties appProperties;

    @BeforeAll
    static void beforeAll() {
        appProperties = AppProperties.getInstance();
        log.info("<<<<<Environment set up properly>>>");

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        log.info("<<<<<Logs from all tests will be displayed>>>>>");
    }
}
