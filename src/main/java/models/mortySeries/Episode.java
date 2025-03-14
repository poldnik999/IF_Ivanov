package models.mortySeries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    private Integer id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

    public List<String> getCharacters() {
        return characters;
    }
}