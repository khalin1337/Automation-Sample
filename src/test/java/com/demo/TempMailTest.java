package com.demo;

import com.demo.Data.RestAssureHelper;
import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.DateTime;
import com.demo.utils.Generator;
import com.demo.utils.SelenideTools;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Pinterest sign up test")
@Feature("Temp mail test")
@Owner("QA Khalin Yevhen")
public class TempMailTest extends BaseTest {
    @Test
    public void tempMailTest(){
        RestAssureHelper.installSpec(RestAssureHelper.requestSpec("https://temp-mail-api3.p.rapidapi.com"),RestAssureHelper.responseSpecOK200());
        String randomEmail = RestAssured
                .given()
                .header("x-rapidapi-key", "My_api") // Ваш API-ключ
                .header("x-rapidapi-host", "temp-mail-api3.p.rapidapi.com") // Хост API
                .when()
                .get("/email/random")
                .then()
                .extract().body().jsonPath().getString("email");
        System.out.println("Відповідь сервера: " + randomEmail);
        Actions.signUpAction().registration(randomEmail, Generator.genString(10), "12.12.2001");
        Assert.assertTrue(Pages.homePage().isRegistrationSuccess(),"Registration is failed");
    }
}
