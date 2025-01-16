package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static ContactUsPage contactUsPage;

    /**
     * This function return an instance of `NavigationPage`
     */

    public static ContactUsPage homePage() {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
        }
        return contactUsPage;
    }
}