package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import com.demo.pages.Rozetka.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.utils.Constants;
@Epic("Rozetka Test")
@Feature("Serch page test")
@Owner("QA Khalin Yevhen")
public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public  void searchTest() throws InterruptedException {
        Selenide.open(Constants.URLRTozetka);
        Constants.SearchWordRozetka = System.getProperty("searchWord", "default_value");
        logInfo("searchWard is " + Constants.SearchWordRozetka);

        Pages.homePage().searchByText(Constants.SearchWordRozetka);

        Assert.assertTrue(Pages.resultPage().isResultsLoad(),"Result on page was not loaded");
    }

}
