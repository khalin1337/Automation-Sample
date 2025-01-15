package com.demo.actions;

import com.demo.pages.HomePage;

public class SignUpAction extends HomePage {

    public void registration(String email, String password, String birthDate) {
        clickSignUpButton();
        fillEmailField(email);
        fillBirthDateField(birthDate);
        fillPasswordField(password);
        clickRegisterFormSubmitButton();
    }
}
