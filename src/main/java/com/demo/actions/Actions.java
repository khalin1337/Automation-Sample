package com.demo.actions;

public class Actions {
    /**
     * Page actions
     */
    private static MainActions mainActions;
    private static SignUpAction signUpAction;
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

}