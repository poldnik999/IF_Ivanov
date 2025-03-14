package api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public class BaseApi {

    public BaseApi(String urlProperties) {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(urlProperties);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
