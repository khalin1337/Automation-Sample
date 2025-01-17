package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static ContactUsPage contactUsPage;
    private static GameTesterPage gameTesterPage;
    private static PilotProjectPage pilotProjectPage;
    private static JuniorSoftwareTesterPage juniorSoftwareTesterPage;
    private static AutomatedTestEngineerPage automatedTestEngineerPage;

    /**
     * This function return an instance of `NavigationPage`
     */

    public static ContactUsPage homePage() {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
        }
        return contactUsPage;
    }
    public static GameTesterPage gameTesterPage() {
        if (gameTesterPage == null) {
            gameTesterPage = new GameTesterPage();
        }
        return gameTesterPage;
    }
    public static JuniorSoftwareTesterPage juniorSoftwareTesterPage() {
        if (juniorSoftwareTesterPage == null) {
            juniorSoftwareTesterPage = new JuniorSoftwareTesterPage();
        }
        return juniorSoftwareTesterPage;
    }
    public static AutomatedTestEngineerPage automatedTestEngineerPage() {
        if (automatedTestEngineerPage == null) {
            automatedTestEngineerPage = new AutomatedTestEngineerPage();
        }
        return automatedTestEngineerPage;
    }
    public static PilotProjectPage pilotProjectPage() {
        if (pilotProjectPage == null) {
            pilotProjectPage = new PilotProjectPage();
        }
        return pilotProjectPage;
    }
}