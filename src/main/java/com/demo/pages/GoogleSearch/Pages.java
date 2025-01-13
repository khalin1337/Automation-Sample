package com.demo.pages.GoogleSearch;

import com.demo.core.allure.AllureLogger;
import com.demo.pages.GoogleSearch.ResultPage;
import com.demo.pages.GoogleSearch.HomePage;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static HomePage homePage;
    private static ResultPage resultPage;

    /**
     * This function return an instance of `NavigationPage`
     */

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public static ResultPage resultPage() {
        if (resultPage == null) {
            resultPage = new ResultPage();
        }
        return resultPage;
    }
}