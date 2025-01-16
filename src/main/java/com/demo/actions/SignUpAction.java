package com.demo.actions;

import com.demo.pages.HomePage;
import com.demo.pages.Pages;

public class SignUpAction  {

    public void registration(String email, String password, String birthDate) {
        Pages.homePage().clickSignUpButton();
        Pages.homePage().fillEmailField(email);
        Pages.homePage().fillBirthDateField(birthDate);
        Pages.homePage().fillPasswordField(password);
        Pages.homePage().clickRegisterFormSubmitButton();
    }
}
