package helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HelpfulMethods {

    Response response;

    public Float getFloat(String stringToParse) {

        return Float.parseFloat(stringToParse);
    }

    public Integer getInteger(String stringToParse) {

        return Integer.parseInt(stringToParse);
    }

    public String getStringFromJson(String path) {

        JsonPath json = response.jsonPath();
        return response.jsonPath().getString(path);


    }
}
