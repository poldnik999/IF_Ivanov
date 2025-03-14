package models.mortySeries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location location;
    private String[] episode;
    private String url;
    private String created;

    public String[] getEpisode() {
        return episode;
    }

    public String getSpecies() {
        return species;
    }

    public Location getLocation() {
        return location;
    }
}

