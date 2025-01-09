package com.demo.pages.Amazon;

import com.demo.core.allure.AllureLogger;
import com.demo.pages.Amazon.HomePage;
import com.demo.pages.Amazon.ProductPage;
import com.demo.pages.Amazon.ResultPage;

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