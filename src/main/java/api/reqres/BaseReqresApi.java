package api.reqres;

import api.Specifications;
import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public abstract class BaseReqresApi {

    private static ConfigLoader prop = new ConfigLoader();

    public BaseReqresApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(prop.getProperty("reqres.url"));
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
