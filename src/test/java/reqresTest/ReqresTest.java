package reqresTest;

import config.ConfigLoader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ReqresSteps;

import java.io.IOException;

public class ReqresTest {

    private static ConfigLoader prop = new ConfigLoader();
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    @DisplayName("Проверка создания user")
    @SneakyThrows
    public void validateCreatedUserTest() throws IOException {
        reqresSteps.createNewUserFromFile(prop.getProperty("json.path"), prop.getProperty("user.name"),prop.getProperty("user.job"), 201);
        reqresSteps.verifyResponse();
    }
}
