package com.demo.actions;

public class Actions {
    /**
     * Page actions
     */
    private static BookActions bookAktions;
    private static BrowserStackActions browserStackActions;
    private static MainActions mainActions;
    private static CalculatorActions calculatorActions;

    /**
     * This function returns an instance of `LoginActions`
     */

    /**
     * This function returns an instance of `MainActions`
     */
    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }
    public static BookActions bookActions() {
        if (bookAktions == null) {
            bookAktions = new BookActions();
        }
        return bookAktions;
    }
    public static BrowserStackActions browserStackActions() {
        if (browserStackActions == null) {
            browserStackActions = new BrowserStackActions();
        }
        return browserStackActions;
    }
    public static CalculatorActions calculatorActions() {
            if (calculatorActions == null) {
                calculatorActions = new CalculatorActions();
            }
            return calculatorActions;
    }

}