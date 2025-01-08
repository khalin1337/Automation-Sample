package com.demo.actions;

public class Actions {
    /**
     * Page actions
     */
    private static BookAktions bookAktions;
    private static MainActions mainActions;

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
    public static BookAktions bookAktions() {
        if (bookAktions == null) {
            bookAktions = new BookAktions();
        }
        return bookAktions;
    }
}