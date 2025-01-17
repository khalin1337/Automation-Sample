package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.Generator;
import com.demo.utils.SelenideTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomatedTestEngineerTest extends BaseTest {

    @Test
    public void successTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField("peker75468@halbov.com");
        Pages.automatedTestEngineerPage().fillNameField("Test");
        Pages.automatedTestEngineerPage().fillTextField("Test");
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        SelenideTools.sleep(10);
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isResultSuccess(),"Form was not sent");//Work
    }
    @Test
    public void wrongFileFormatTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestWrongCV.txt");
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageIncorrectFileFormat(),"Error message does not contain message about wrong file format");//Work
    }
    @Test
    public void notUploadedFileTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageNotUploadFile(),"Error message does not contain message about missing file");//Work
    }

    @Test
    public void allFieldsEmpty() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.homePage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyPhoneField(),
                "Error message does not contain message about empty phone field");
        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageNotUploadFile(),
                "Error message does not contain message about not uploaded file");
        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyCaptchaField(),
                "Error message does not contain message about empty captcha field");
        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyNameField(),
                "Error message does not contain message about empty name field");
        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyMailField(),
                "Error message does not contain message about empty Email field");
        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyTextField(),
                "Error message does not contain message about empty text field");//Work
    }
    @Test
    public void emptyNameFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");//Work
    }

    @Test
    public void emptyEmailFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyMailField(),"Error message does not contain message about empty Email field");//Work
    }

    @Test
    public void emptyPhoneFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyPhoneField(),"Error message does not contain message about empty phone field");//Work
    }

    @Test
    public void emptyTextFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }

    @Test
    public void emptyCaptchaFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");//Work
    }

    @Test
    public void incorrectCaptchaAnswerTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().failCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField(Generator.genEmail());
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");//Work
    }

    @Test
    public void incorrectEmailFieldTest() {
        SelenideTools.openUrl(Constants.AutomatedTestEngineerURL);

        Pages.automatedTestEngineerPage().clickApplicationButton();
        Pages.automatedTestEngineerPage().passCaptcha();
        Pages.automatedTestEngineerPage().fillEmailField("Error");
        Pages.automatedTestEngineerPage().fillNameField(Generator.genString(10));
        Pages.automatedTestEngineerPage().fillTextField(Generator.genString(100));
        Pages.automatedTestEngineerPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.automatedTestEngineerPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.automatedTestEngineerPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.automatedTestEngineerPage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");//Work
    }
}
