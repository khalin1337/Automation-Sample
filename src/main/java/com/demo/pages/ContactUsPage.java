package com.demo.pages;

import com.demo.actions.Actions;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class ContactUsPage extends PageTools {

    private final By nameField = By.xpath("//div[@class='et_pb_contact']//input[@id='et_pb_contact_name_0']");
    private final By emailField = By.xpath("//div[@class='et_pb_contact']//input[@id='et_pb_contact_email_0']");
    private final By textField = By.xpath("//div[@class='et_pb_contact']//textarea[@id='et_pb_contact_message_0']");
    private final By submitButton = By.xpath("//button[@class='et_pb_contact_submit et_pb_button']");
    private final By captchaExpressionField = By.xpath("//div[@class='et_pb_contact_right']//span[@class='et_pb_contact_captcha_question']");
    private final By captchaAnswerField = By.xpath("//div[@class='et_pb_contact_right']//input[@class='input et_pb_contact_captcha']");
    private final By successResult = By.xpath("//div[@class='et-pb-contact-message et_pb_success_message']");
    private final By errorMessages = By.xpath("//div[@class='et-pb-contact-message et_pb_contact_message_top et_pb_contact_error_meesage']");

    public void clickSubmitButton() {
        click(submitButton);
    }
    private String getCaptchaExpression() {
        return getElementText(captchaExpressionField);
    }
    private void fillCaptchaAnswerField(String answer) {
         type(answer,captchaAnswerField);
    }
    public void fillNameField(String name) {
         type(name,nameField);
    }
    public void fillEmailField(String email) {
         type(email,emailField);
    }
    public void fillTextField(String text) {
         type(text,textField);
    }
    private String getSuccessMessage() {
        return getElementText(successResult);
    }
    public boolean isResultSuccess() {
        return getSuccessMessage().contains("Thank You for Request!");
    }
    public boolean isErrorContainMessageEmptyMailField() {
        return getErrorMessages().contains("Email Address");
    }
    public boolean isErrorContainMessageEmptyTextField() {
        return getErrorMessages().contains("Message");
    }
    public boolean isErrorContainMessageEmptyCaptchaField() {
        return getErrorMessages().contains("Captcha");
    }
    public boolean isErrorContainMessageEmptyNameField() {
        return getErrorMessages().contains("Name");
    }
    public boolean isErrorContainMessageIncorrectCaptchaField() {
        return getErrorMessages().contains("You entered the wrong number in captcha");
    }
    public boolean isErrorContainMessageIncorrectEmailField() {
        return getErrorMessages().contains("Invalid email");
    }
    public void passCaptcha() {
        fillCaptchaAnswerField(Actions.testmatickActions().doExpression(getCaptchaExpression()));
    }
    public void failCaptcha() {
        fillCaptchaAnswerField("error");
    }
    public String getErrorMessages() {
        return getElementText(errorMessages);
    }


}