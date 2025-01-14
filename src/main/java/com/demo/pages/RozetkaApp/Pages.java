package com.demo.pages.RozetkaApp;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static HomePage homePage;
    private static CartPage cartPage;
    private static ProductPage productPage;

    /**
     * This function return an instance of `NavigationPage`
     */

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public static CartPage cartPage() {
            if (cartPage == null) {
                cartPage = new CartPage();
            }
            return cartPage;
    }
    public static ProductPage productPage() {
            if (productPage == null) {
                productPage = new ProductPage();
            }
            return productPage;
    }


}