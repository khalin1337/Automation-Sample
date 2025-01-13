package com.demo.GoogleTest;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.remote.RemoteWebDriver;
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

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Epic("Google Search Test")
@Feature("Serch test")
@Owner("QA Khalin Yevhen")
public class GoogleSearchTest extends BrowserStackTest {

    @Test(priority = 1)
    @Parameters("keyWords")
    public void googleSearchTest(String keyWord) throws Exception{
        Selenide.open(Constants.URLGoogle);
        sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

        Pages.homePage().searchByWord(keyWord);
        boolean result = Pages.resultPage().isAllResultsContainsSearchWord(keyWord);

        if(result)endSession(sessionId, userName, accessKey, true, "Test completed successfully");
        else endSession(sessionId, userName, accessKey, false, "Not all results contain the keyword");


        Assert.assertTrue(result,
                "Not all results" + Pages.resultPage().getAllResults() + "contain the keyword: " + keyWord);
    }
}
