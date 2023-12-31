package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class CreateUserSpecs {
    public static RequestSpecification createUserRequestSpec = with()
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification createUserSuccessful201ResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .expectBody(matchesJsonSchemaInClasspath("schemes/create-new-user-successful-post-201.json"))
            .build();
}
