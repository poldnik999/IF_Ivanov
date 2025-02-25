package steps;

import api.reqres.ReqresApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import models.reqres.User;


import java.io.File;
import java.io.IOException;

public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();
    private ObjectMapper objectMapper = new ObjectMapper();
    private ValidatableResponse response;
    private User oldUser;

    public void createNewUserFromFile(String jsonPath, String setName, String setJob, int expectedStatusCode) throws IOException {

        oldUser = objectMapper.readValue(new File(jsonPath), User.class);
        oldUser.setName(setName);
        oldUser.setJob(setJob);
        response = reqresApi.postUser(oldUser).statusCode(expectedStatusCode);

    }
    public void verifyResponse() {

        User createdUser = response.extract().body().as(User.class);
        assert createdUser.getName().equals(oldUser.name);
        assert createdUser.getJob().equals(oldUser.job);
    }
}

