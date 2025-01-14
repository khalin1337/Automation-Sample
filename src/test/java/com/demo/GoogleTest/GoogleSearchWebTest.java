package com.demo.GoogleTest;

import com.codeborne.selenide.Selenide;
import com.demo.actions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.demo.core.base.BrowserStackWebTest;
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
public class GoogleSearchWebTest extends BrowserStackWebTest {

    @Test(priority = 1)
    @Parameters("keyWords")
    public void googleSearchTest(String keyWord) throws Exception{
        Selenide.open(Constants.URLGoogle);
        sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

        Pages.homePage().searchByWord(keyWord);

        if (Pages.resultPage().isAllResultsContainsSearchWord(keyWord))
            Actions.browserStackActions().setWebTestStatus
                    (userName, accessKey, true, "Test completed successfully");
        else
            Actions.browserStackActions().setWebTestStatus
                    (userName, accessKey, false, "Not all results contain the keyword");

        Assert.assertTrue(Pages.resultPage().isAllResultsContainsSearchWord(keyWord),
                "Not all results " + Pages.resultPage().getAllResults() + " contain the keyword: " + keyWord);
    }
}
