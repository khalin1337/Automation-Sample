package com.demo;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Khalin Yevhen")
public class FirstTest extends BaseTest {

    @Test(description = "FirstTest")
    public void firstTest() {
    }
}
