package api.reqres;

import api.BaseApi;
import config.ConfigLoader;
import io.restassured.response.ValidatableResponse;
import models.reqres.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseApi {

    private static final String USER_URN = "/user";
    private static ConfigLoader prop = new ConfigLoader();

    public ReqresApi() {
        super(prop.getProperty("reqres.url"));
    }

    public ValidatableResponse postUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USER_URN)
                .then();
    }
}
