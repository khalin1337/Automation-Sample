package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static HomePage homePage;
    private static ProductPage productPage;
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
    public static ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
}