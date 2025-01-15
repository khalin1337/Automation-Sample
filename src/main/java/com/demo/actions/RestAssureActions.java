package com.demo.actions;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssureActions {

    public List<String> getRandomNumbers(String min, String max, String count) {
        installSpec(requestSpec("http://www.randomnumberapi.com/api/v1.0/randomnumber"), responseSpecOK200());
        return given()
                .when()
                .get(String.format("?min=%s&max=%s&count=%s",min,max,count))
                .then()
                .extract().body().jsonPath().get();
    }
    public RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.TEXT)
                .build();
    }
    public ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public ResponseSpecification responseSpecError400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public void installSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
