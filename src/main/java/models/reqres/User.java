package models.reqres;

import lombok.Data;

@Data
public class User {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
