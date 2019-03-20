package scenarios.setup;

import io.restassured.RestAssured;

public class HttpResponseCode {
    public int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
    }

    public int httpResponseCodeViaPost(String url) {
        return RestAssured.post(url).statusCode();
    }

}
