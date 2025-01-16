package com.demo.actions;

import io.restassured.RestAssured;

public class RestAssureActions {
    public String getMail() {
        return RestAssured
                .given()
                .header("x-rapidapi-key", "My_api") // Ваш API-ключ
                .header("x-rapidapi-host", "temp-mail-api3.p.rapidapi.com") // Хост API
                .when()
                .get("/email/random")
                .then()
                .extract().body().jsonPath().getString("email");
    }
}
