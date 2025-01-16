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


    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static String getRandomMail() {
        installSpec(requestSpec("https://temp-mail-api3.p.rapidapi.com"),responseSpecOK200());
        String randomEmail = RestAssured
                .given()
                .header("x-rapidapi-key", "My_api") // Ваш API-ключ
                .header("x-rapidapi-host", "temp-mail-api3.p.rapidapi.com") // Хост API
                .when()
                .get("/email/random")
                .then()
                .extract().body().jsonPath().getString("email");
        System.out.println("Відповідь сервера: " + randomEmail);
        return randomEmail;
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