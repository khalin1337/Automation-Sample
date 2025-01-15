package com.demo.Data;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssureHelper {

    public static List<String> getRandomNumbers(String min, String max, String count) {
        return given()
                .when()
                .get(String.format("?min=%s&max=%s&count=%s",min,max,count))
                .then()
                .extract().body().jsonPath().get();
    }
    public static int getRandomNumber(String min, String max) {
        return given()
                .when()
                .get(String.format("?min=%s&max=%s",min,max))
                .then()
                .extract().body().jsonPath().get("[0]");
    }

    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.TEXT)
                .build();
    }
    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecError400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public static void installSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}