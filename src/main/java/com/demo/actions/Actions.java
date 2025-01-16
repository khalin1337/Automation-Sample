package com.demo.actions;

public class Actions {
    /**
     * Page actions
     */
    private static MainActions mainActions;
    private static TestmatickActions testmatickActions;
    /**
     * This function returns an instance of `MainActions`
     */
    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }
    public static TestmatickActions testmatickActions() {
        if (testmatickActions == null) {
            testmatickActions = new TestmatickActions();
        }
        return testmatickActions;
    }

}