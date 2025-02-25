package models.mortySeries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    public Integer id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Location location;
    public String[] episode;
    public String url;
    public String created;
}

