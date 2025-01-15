package com.demo.pages.Calculator;

import com.demo.core.allure.AllureLogger;
public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static HomePage homePage;
    /**
     * This function return an instance of `NavigationPage`
     */
    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
}