package api.reqres;

import io.restassured.response.ValidatableResponse;
import models.reqres.User;
import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseReqresApi{

    private static final String USER_URN = "/user";

    public ValidatableResponse postUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USER_URN)
                .then();
    }
}
