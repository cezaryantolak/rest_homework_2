package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class WeatherTests extends BaseTest {

    @Test
    public void shouldGiveProperMinimumTemperatureForLondon() {

        given(generateRequestSpecification()).
        when().
                get(System.getProperty("url")).
        then().
                spec(generateResponseSpecification()).
                body(System.getProperty("minimumTemperaturePath"), is(getFloat(System.getProperty("minimumTemperature"))));
    }

    @Test
    public void shouldGiveProperWeatherDescription() {

        given(generateRequestSpecification()).
                when().
                get(System.getProperty("url")).
                then().
                spec(generateResponseSpecification()).
                body(System.getProperty("weatherDescriptionPath"), is(System.getProperty("weatherDescription")));
    }
}
