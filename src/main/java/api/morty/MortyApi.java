package api.morty;

import api.BaseApi;
import config.ConfigLoader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MortyApi extends BaseApi {

    private static ConfigLoader prop = new ConfigLoader();

    public MortyApi() {
        super(prop.getProperty("morty.url"));
    }

    public Response getCharacterByName(String name) {
        return given()
                .queryParam("name", name)
                .get("/character");
    }

    public Response getResource(String url) {
        return given()
                .baseUri("")
                .get(url);
    }
}
