package models.mortySeries;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    public Integer id;
    public String name;
    public String air_date;
    public String episode;
    public List<String> characters;
    public String url;
    public String created;
}