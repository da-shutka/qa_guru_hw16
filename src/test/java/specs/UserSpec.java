package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class UserSpec {
    public static RequestSpecification userRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().method()
            .log().uri()
            .log().body();

    public static ResponseSpecification userResponse201Spec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification userResponse200Spec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification userResponse204Spec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(204)
            .build();
}