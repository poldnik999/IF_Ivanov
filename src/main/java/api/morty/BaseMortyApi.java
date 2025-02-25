package api.morty;

import api.Specifications;
import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public abstract class BaseMortyApi {

    private static ConfigLoader prop = new ConfigLoader();

    public BaseMortyApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(prop.getProperty("morty.url"));
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
