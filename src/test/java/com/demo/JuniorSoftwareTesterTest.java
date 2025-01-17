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
@Feature("Junior Software Tester tests")
@Owner("QA Khalin Yevhen")
public class JuniorSoftwareTesterTest extends BaseTest {
     @Test
    public void successTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().passCaptcha();
        Pages.juniorSoftwareTesterPage().fillEmailField("peker75468@halbov.com");
        Pages.juniorSoftwareTesterPage().fillNameField("Test");
        Pages.juniorSoftwareTesterPage().fillTextField("Test");
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        SelenideTools.sleep(10);
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isResultSuccess(),"Form was not sent");//Work
    }
   @Test
   public void wrongFileFormatTest() {
       SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

       Pages.juniorSoftwareTesterPage().clickApplicationButton();
       Pages.juniorSoftwareTesterPage().passCaptcha();
       Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
       Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
       Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
       Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestWrongCV.txt");
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageIncorrectFileFormat(),"Error message does not contain message about wrong file format");//Work
   }
   @Test
   public void notUploadedFileTest() {
       SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

       Pages.juniorSoftwareTesterPage().clickApplicationButton();
       Pages.juniorSoftwareTesterPage().passCaptcha();
       Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
       Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
       Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
       Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.juniorSoftwareTesterPage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageNotUploadFile(),"Error message does not contain message about missing file");//Work
   }

   @Test
   public void allFieldsEmpty() {
       SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

       Pages.juniorSoftwareTesterPage().clickApplicationButton();
       Pages.homePage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyPhoneField(),
               "Error message does not contain message about empty phone field");
       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageNotUploadFile(),
               "Error message does not contain message about not uploaded file");
       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyCaptchaField(),
               "Error message does not contain message about empty captcha field");
       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyNameField(),
               "Error message does not contain message about empty name field");
       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyMailField(),
               "Error message does not contain message about empty Email field");
       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyTextField(),
               "Error message does not contain message about empty text field");//Work
   }
   @Test
   public void emptyNameFieldTest() {
       SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

       Pages.juniorSoftwareTesterPage().clickApplicationButton();
       Pages.juniorSoftwareTesterPage().passCaptcha();
       Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
       Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
       Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.juniorSoftwareTesterPage().clickSubmitButton();
       SelenideTools.sleep(2);

       Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");//Work
   }

    @Test
    public void emptyEmailFieldTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().passCaptcha();
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyMailField(),"Error message does not contain message about empty Email field");//Work
    }

    @Test
    public void emptyPhoneFieldTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().passCaptcha();
        Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyPhoneField(),"Error message does not contain message about empty phone field");//Work
    }

    @Test
    public void emptyTextFieldTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().passCaptcha();
        Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }

    @Test
    public void emptyCaptchaFieldTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");//Work
    }

    @Test
    public void incorrectCaptchaAnswerTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().failCaptcha();
        Pages.juniorSoftwareTesterPage().fillEmailField(Generator.genEmail());
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");//Work
    }

    @Test
    public void incorrectEmailFieldTest() {
        SelenideTools.openUrl(Constants.JuniorSoftwareTesterURL);

        Pages.juniorSoftwareTesterPage().clickApplicationButton();
        Pages.juniorSoftwareTesterPage().passCaptcha();
        Pages.juniorSoftwareTesterPage().fillEmailField("Error");
        Pages.juniorSoftwareTesterPage().fillNameField(Generator.genString(10));
        Pages.juniorSoftwareTesterPage().fillTextField(Generator.genString(100));
        Pages.juniorSoftwareTesterPage().fillPhoneField(Generator.genMobilePhone(10));
        Pages.juniorSoftwareTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestCV.docx");
        Pages.juniorSoftwareTesterPage().clickSubmitButton();
        SelenideTools.sleep(2);

        Assert.assertTrue(Pages.juniorSoftwareTesterPage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");//Work
    }
}
