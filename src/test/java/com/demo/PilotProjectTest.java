package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import com.demo.utils.Generator;
import com.demo.utils.SelenideTools;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Testmatick test")
@Feature("Pilot project tests")
@Owner("QA Khalin Yevhen")
public class PilotProjectTest extends BaseTest {

    @Test()
    public void successTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField("peker75468@halbov.com");
        Pages.pilotProjectPage().fillTextField("Test");
        Pages.pilotProjectPage().fillNameField("Test");
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().fillCompanyField("Test");
        SelenideTools.sleep(20);
        Pages.pilotProjectPage().clickSubmitButton();
        Assert.assertTrue(Pages.pilotProjectPage().isResultSuccess(),"Form was not sent");//Work
    }
    @Test()
    public void emptyNameFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyNameField(),
                "Error message does not contain message about empty name field");//Work
    }
    @Test()
    public void emptyEmailFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyMailField(),
                "Error message does not contain message about empty email field");//Work
    }

    @Test()
    public void emptyCountryFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCountryField(),
                "Error message does not contain message about empty country field");//Work
    }
    @Test()
    public void emptyCompanyFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCompanyField(),
                "Error message does not contain message about empty company field");//Work
    }

    @Test()
    public void emptyTextFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);
        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyTextField(),
                "Error message does not contain message about empty text field");//Work
    }

    @Test()
    public void emptyCaptchaFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);

        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCaptchaField(),
                "Error message does not contain message about empty captcha field");//Work
    }
   @Test()
   public void allFieldsEmptyTest() {
       SelenideTools.openUrl(Constants.PilotProjectURL);

       Pages.pilotProjectPage().clickSubmitButton();

       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyNameField(),
               "Error message does not contain message about empty name field");
       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyMailField(),
               "Error message does not contain message about empty email field");
       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCountryField(),
               "Error message does not contain message about empty country field");
       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCompanyField(),
               "Error message does not contain message about empty company field");
       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyTextField(),
               "Error message does not contain message about empty text field");
       Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageEmptyCaptchaField(),
               "Error message does not contain message about empty captcha field");//Work
   }

    @Test()
    public void incorrectCaptchaAnswerTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);

        Pages.pilotProjectPage().failCaptcha();
        Pages.pilotProjectPage().fillEmailField(Generator.genEmail());
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageIncorrectCaptchaField(),
                "Error message does not contain message about incorrect captcha field");//Work
    }
    @Test()
    public void incorrectEmailFieldTest() {
        SelenideTools.openUrl(Constants.PilotProjectURL);

        Pages.pilotProjectPage().passCaptcha();
        Pages.pilotProjectPage().fillEmailField("Error");
        Pages.pilotProjectPage().fillNameField(Generator.genString(10));
        Pages.pilotProjectPage().fillCompanyField(Generator.genString(10));
        Pages.pilotProjectPage().fillTextField(Generator.genString(100));
        Pages.pilotProjectPage().chooseCountryField("Ukraine");
        Pages.pilotProjectPage().clickSubmitButton();

        Assert.assertTrue(Pages.pilotProjectPage().isErrorContainMessageIncorrectEmailField(),
                "Error message does not contain message about incorrect email field");//Work
    }
}
