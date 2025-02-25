package mortyTests;

import config.ConfigLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.MortySteps;
import static org.junit.jupiter.api.Assertions.*;

public class MortyTest {

    private static ConfigLoader prop = new ConfigLoader();
    private final MortySteps mortySteps = new MortySteps();

    @Test
    @DisplayName("Проверка расы и локации двух персонажей")
    void negativeMortyTest() {

        mortySteps.getCharacterInfo(prop.getProperty("character.name"));
        String mortySpecies = mortySteps.getCurrentCharacterSpecies();
        String mortyLocation = mortySteps.getCurrentCharacterLocation();

        mortySteps.getLastEpisodeInfo();
        mortySteps.getLastCharacterFromEpisode();
        assertEquals(mortySpecies, mortySteps.getCurrentCharacterSpecies());
        assertNotEquals(mortyLocation, mortySteps.getCurrentCharacterLocation());
    }

}
