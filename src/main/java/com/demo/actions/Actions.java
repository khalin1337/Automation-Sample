package com.demo.actions;

public class Actions {
    /**
     * Page actions
     */
    private static MainActions mainActions;
    private static SignUpAction signUpAction;
    private static RestAssureActions restAssureActions;
    /**
     * This function returns an instance of `MainActions`
     */
    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }
    public static SignUpAction signUpAction() {
        if (signUpAction == null) {
            signUpAction = new SignUpAction();
        }
        return signUpAction;
    }
    public static RestAssureActions restAssureActions() {
        if (restAssureActions == null) {
            restAssureActions = new RestAssureActions();
        }
        return restAssureActions;
    }

}