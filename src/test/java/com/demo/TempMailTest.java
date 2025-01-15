package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.utils.SelenideTools;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class TempMailTest extends BaseTest {
    @Test
    public void tempMailTest(){

        List<String> qwe = RestAssured.given()
                .when()
                .contentType(ContentType.TEXT)
                .get("https://temp-mail.org/uk/api")
                .then()
                .extract().body().jsonPath().get();
        System.out.println(qwe);
        SelenideTools.sleep(10);
    }
}
