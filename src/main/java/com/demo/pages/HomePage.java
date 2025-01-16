package com.demo.pages;

import com.demo.core.base.PageTools;
import com.demo.utils.SelenideTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {

    private final By signUpButton = By.xpath("//div[@data-test-id='simple-signup-button']/button");
    private final By emailField = By.xpath("//div[@data-test-id='emailInputField']//span//input");
    private final By birthDateField = By.xpath("//div[@data-test-id='signup-birthdate-field']//span//input");
    private final By passwordField = By.xpath("//div[@data-test-id='passwordInputField']//span//input");
    private final By registerFormSubmitButton = By.xpath("//div[@data-test-id='registerFormSubmitButton']/button");
    private final By welcomingForm = By.xpath("//div[@data-test-id='nux-welcome-step-container']");

    public void clickSignUpButton() {
        click(signUpButton);
    }
    public void clickRegisterFormSubmitButton() {
        click(registerFormSubmitButton);
    }
    public void fillEmailField(String value){
        type(value,emailField);
    }
    public void fillBirthDateField(String value){
        type(value, birthDateField);
    }
    public void fillPasswordField(String value){
        type(value,passwordField);
    }
    public boolean isRegistrationSuccess() {
        SelenideTools.sleep(10);
       return isElementVisible(welcomingForm);
    }
}