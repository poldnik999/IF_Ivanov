package steps;

import api.morty.MortyApi;
import models.mortySeries.Character;
import models.mortySeries.Episode;

public class MortySteps {

    private final MortyApi api = new MortyApi();
    private Character lastCharacter;
    private Episode lastEpisode;

    public void getCharacterInfo(String name) {
        Character character = api.getCharacterByName(name)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("results[0]", Character.class);

        lastCharacter = character;
    }

    public void getLastEpisodeInfo() {
        String lastEpisodeUrl = lastCharacter.getEpisode()[lastCharacter.getEpisode().length - 1];
        lastEpisode = api.getEpisode(lastEpisodeUrl)
                .then()
                .statusCode(200)
                .extract()
                .as(Episode.class);
    }

    public void getLastCharacterFromEpisode() {
        String lastCharacterUrl = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        lastCharacter = api.getCharacter(lastCharacterUrl)
                .then()
                .statusCode(200)
                .extract()
                .as(Character.class);
    }

    public String getCurrentCharacterSpecies() {
        return lastCharacter.getSpecies();
    }

    public String getCurrentCharacterLocation() {
        return lastCharacter.getLocation().getName();
    }
}
