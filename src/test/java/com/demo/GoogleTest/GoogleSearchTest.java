package com.demo.GoogleTest;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import com.demo.core.base.BrowserStackTest;
import com.demo.pages.GoogleSearch.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Epic("Google Search Test")
@Feature("Serch test")
@Owner("QA Khalin Yevhen")
public class GoogleSearchTest extends BrowserStackTest {

    @Test(priority = 1)
    @Parameters("keyWords")
    public void googleSearchTest(String keyWord) throws Exception{
        Selenide.open(Constants.URLGoogle);

        Pages.homePage().searchByWord(keyWord);

        Assert.assertTrue(Pages.resultPage().isAllResultsContainsSearchWord(keyWord),
                "Not all results" + Pages.resultPage().getAllResults() + "contain the keyword: " + keyWord);
    }
}
