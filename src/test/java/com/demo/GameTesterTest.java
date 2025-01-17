package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.Generator;
import com.demo.utils.SelenideTools;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Testmatick test")
@Feature("Game tester tests")
@Owner("QA Khalin Yevhen")
public class GameTesterTest extends BaseTest {
    @Test
    public void successTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().passCaptcha();
        Pages.gameTesterPage().fillEmailField("peker75468@halbov.com");
        Pages.gameTesterPage().fillNameField("Test");
        Pages.gameTesterPage().fillTextField("Test");
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        SelenideTools.sleep(10);
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isResultSuccess(),"Form was not sent");//Work
    }
   @Test
   public void wrongFileFormatTest() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.gameTesterPage().passCaptcha();
       Pages.gameTesterPage().fillEmailField(Generator.genEmail());
       Pages.gameTesterPage().fillNameField(Generator.genString(10));
       Pages.gameTesterPage().fillTextField(Generator.genString(100));
       Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestWrongCV.txt");
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageIncorrectFileFormat(),"Error message does not contain message about wrong file format");//Work
   }
   @Test
   public void notUploadedFileTest() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.gameTesterPage().passCaptcha();
       Pages.gameTesterPage().fillEmailField(Generator.genEmail());
       Pages.gameTesterPage().fillNameField(Generator.genString(10));
       Pages.gameTesterPage().fillTextField(Generator.genString(100));
       Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.gameTesterPage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageNotUploadFile(),"Error message does not contain message about missing file");//Work
   }

   @Test
   public void allFieldsEmpty() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.homePage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyPhoneField(),
               "Error message does not contain message about empty phone field");
       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageNotUploadFile(),
               "Error message does not contain message about not uploaded file");
       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyCaptchaField(),
               "Error message does not contain message about empty captcha field");
       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyNameField(),
               "Error message does not contain message about empty name field");
       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyMailField(),
               "Error message does not contain message about empty Email field");
       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyTextField(),
               "Error message does not contain message about empty text field");//Work
   }
   @Test
   public void emptyNameFieldTest() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.gameTesterPage().passCaptcha();
       Pages.gameTesterPage().fillEmailField(Generator.genEmail());
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
       Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
       Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.gameTesterPage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");//Work
   }

    @Test
    public void emptyEmailFieldTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().passCaptcha();
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyMailField(),"Error message does not contain message about empty Email field");//Work
    }

    @Test
    public void emptyPhoneFieldTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().passCaptcha();
        Pages.gameTesterPage().fillEmailField(Generator.genEmail());
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyPhoneField(),"Error message does not contain message about empty phone field");//Work
    }

    @Test
    public void emptyTextFieldTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().passCaptcha();
        Pages.gameTesterPage().fillEmailField(Generator.genEmail());
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }

    @Test
    public void emptyCaptchaFieldTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().fillEmailField(Generator.genEmail());
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");//Work
    }

    @Test
    public void incorrectCaptchaAnswerTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().failCaptcha();
        Pages.gameTesterPage().fillEmailField(Generator.genEmail());
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");//Work
    }

    @Test
    public void incorrectEmailFieldTest() {
        SelenideTools.openUrl(Constants.GameTesterURL);

        Pages.gameTesterPage().clickApplicationButton();
        Pages.gameTesterPage().passCaptcha();
        Pages.gameTesterPage().fillEmailField("Error");
        Pages.gameTesterPage().fillNameField(Generator.genString(10));
        Pages.gameTesterPage().fillTextField(Generator.genString(100));
        Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.gameTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");//Work
    }
}
