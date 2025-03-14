package steps;

import api.reqres.ReqresApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigLoader;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.reqres.User;

import java.io.File;
import java.io.IOException;

public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();
    private ObjectMapper objectMapper = new ObjectMapper();
    private ValidatableResponse response;
    private User oldUser;

    private static ConfigLoader prop = new ConfigLoader();

    @Когда("Создаем нового пользователя с именем {string} и должностью {string}; Статус код - {int}")
    @Step("Создаем нового пользователя с именем {setName} и должностью {setJob}; Статус код - {expectedStatusCode}")
    public void createNewUserFromFile(String setName, String setJob, int expectedStatusCode) throws IOException {
        oldUser = objectMapper.readValue(new File(prop.getProperty("json.path")), User.class);
        oldUser.setName(setName);
        oldUser.setJob(setJob);
        response = reqresApi.postUser(oldUser).statusCode(expectedStatusCode);
        Allure.addAttachment("User " + oldUser.getName(), oldUser.toString());

    }

    @Тогда("Проверяем соответствие данных в ответе")
    @Step("Проверяем соответствие данных в ответе")
    public void verifyResponse() {
        User createdUser = response.extract().body().as(User.class);
        Allure.addAttachment("Created user " + createdUser.getName(), createdUser.toString());
        assert createdUser.getName().equals(oldUser.getName());
        assert createdUser.getJob().equals(oldUser.getJob());
    }
}

