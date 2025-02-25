package api.morty;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class MortyApi extends BaseMortyApi {

    public Response getCharacterByName(String name) {
        return given()
                .queryParam("name", name)
                .get("/character");
    }

    public Response getEpisode(String url) {
        return given()
                .baseUri("")
                .get(url);
    }

    public Response getCharacter(String url) {
        return given()
                .baseUri("")
                .get(url);
    }
}
