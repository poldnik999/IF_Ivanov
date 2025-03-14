package steps;

import api.morty.MortyApi;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import models.mortySeries.Character;
import models.mortySeries.Episode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MortySteps {

    private final MortyApi api = new MortyApi();
    private Character originalCharacter;
    private Character lastCharacter;
    private Episode lastEpisode;

    @Когда("Получаем информацию о персонаже {string}")
    @Step("Получаем информацию о персонаже {name}")
    public void getCharacterInfo(String name) {
        Character character = api.getCharacterByName(name)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("results[0]", Character.class);
        originalCharacter = character;
        lastCharacter = character;
        Allure.addAttachment("originalCharacter ", originalCharacter.toString());
    }

    @И("Находим последний эпизод, где появлялся персонаж")
    @Step("Находим последний эпизод, где появлялся персонаж")
    public void getLastEpisodeInfo() {
        String lastEpisodeUrl = lastCharacter.getEpisode()[lastCharacter.getEpisode().length - 1];
        lastEpisode = fetchResource(Episode.class, lastEpisodeUrl);
    }

    @И("Получаем последнего персонажа из этого эпизода")
    @Step("Получаем последнего персонажа из этого эпизода")
    public void getLastCharacterFromEpisode() {
        String lastCharacterUrl = lastEpisode.getCharacters().get(lastEpisode.getCharacters().size() - 1);
        lastCharacter = fetchResource(Character.class, lastCharacterUrl);
    }

    @Затем("Проверяем совпадение расы персонажей")
    @Step("Проверяем совпадение расы персонажей")
    public void assertEqualsSpecies() {
        assertEquals(originalCharacter.getSpecies(), lastCharacter.getSpecies());
    }

    @И("Проверяем несовпадение локации персонажей")
    @Step("Проверяем несовпадение локации персонажей")
    public void assertNotEqualsLocation() {
        assertNotEquals(originalCharacter.getLocation().getName(), lastCharacter.getLocation().getName());
    }

    private <T> T fetchResource(Class<T> responseClass, String url) {
        T resource = api.getResource(url)
                .then()
                .statusCode(200)
                .extract()
                .as(responseClass);
        Allure.addAttachment(resource.getClass().getName(), resource.toString());
        return resource;
    }
}
