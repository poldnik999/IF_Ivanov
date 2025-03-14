package models.mortySeries;

import lombok.Data;

@Data
public class Location {
    private String name;
    private String url;

    public String getName() {
        return name;
    }
}