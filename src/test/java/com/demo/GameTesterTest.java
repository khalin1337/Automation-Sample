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
   /* @Test
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
    }*/
   /*@Test
   public void wrongFileFormatTest() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.gameTesterPage().passCaptcha();
       Pages.gameTesterPage().fillEmailField("peker75468@halbov.com");
       Pages.gameTesterPage().fillNameField("Test");
       Pages.gameTesterPage().fillTextField("Test");
       Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.gameTesterPage().uploadTestCV("src\\main\\java\\com\\demo\\Data\\TestWrongCV.txt");

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageIncorrectFileFormat(),"Error message does not contain message about wrong file format");//Work
   }*/
   /*@Test
   public void notUploadedFileTest() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.gameTesterPage().passCaptcha();
       Pages.gameTesterPage().fillEmailField("peker75468@halbov.com");
       Pages.gameTesterPage().fillNameField("Test");
       Pages.gameTesterPage().fillTextField("Test");
       Pages.gameTesterPage().fillPhoneField(Generator.genMobilePhone(10));
       Pages.gameTesterPage().clickSubmitButton();

       Assert.assertTrue(Pages.gameTesterPage().isErrorContainMessageNotUploadFile(),"Error message does not contain message about missing file");//Work
   }*/
   /*@Test
   public void allFieldsEmpty() {
       SelenideTools.openUrl(Constants.GameTesterURL);

       Pages.gameTesterPage().clickApplicationButton();
       Pages.homePage().clickSubmitButton();

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
   }*/
}
