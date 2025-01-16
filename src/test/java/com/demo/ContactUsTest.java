package com.demo;

import com.codeborne.selenide.Selenide;
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
@Feature("Contact us tests")
@Owner("QA Khalin Yevhen")
public class ContactUsTest extends BaseTest {
    @Test()
    public void successTest() {
        SelenideTools.openUrl(Constants.ContactUsURL);
        Pages.homePage().passCaptcha();
        Pages.homePage().fillEmailField("peker75468@halbov.com");//Temp Mail(because api for random mail has reached limit)
        Pages.homePage().fillTextField("Test");
        Pages.homePage().fillNameField("Test");
        SelenideTools.sleep(20);
        Pages.homePage().clickSubmitButton();
        Assert.assertTrue(Pages.homePage().isResultSuccess(),"Form was not sent");//Work
    }
    @Test
    public void allFieldsEmpty() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyMailField(),"Error message does not contain message about empty Email field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }
    @Test
    public void emptyNameField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().passCaptcha();
        Pages.homePage().fillEmailField(Generator.genEmail());
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");//Work
    }
    @Test
    public void emptyEmailField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().passCaptcha();
        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyMailField(),"Error message does not contain message about empty Email field");//Work
    }
    @Test
    public void emptyTextField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().passCaptcha();
        Pages.homePage().fillEmailField(Generator.genEmail());
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty Text field");//Work
    }
    @Test
    public void emptyCaptchaField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().fillEmailField(Generator.genEmail());
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");//Work
    }
    @Test
    public void incorrectEmailField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().fillEmailField("Error");
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");//Work
    }
    @Test
    public void incorrectCaptchaField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().fillEmailField(Generator.genEmail());
        Pages.homePage().failCaptcha();
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");//Work
    }
    @Test
    public void incorrectCaptchaAndMailField() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillTextField(Generator.genString(100));
        Pages.homePage().fillNameField(Generator.genString(10));
        Pages.homePage().fillEmailField("Error");
        Pages.homePage().failCaptcha();
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");//Work
    }
    @Test
    public void incorrectCaptchaAndMailOtherFieldsEmpty() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillEmailField("Error");
        Pages.homePage().failCaptcha();
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectCaptchaField(),"Error message does not contain message about incorrect captcha field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }
    @Test
    public void incorrectMailAndOtherFieldsEmpty() {
        SelenideTools.openUrl(Constants.ContactUsURL);

        Pages.homePage().fillEmailField("Error");
        Pages.homePage().clickSubmitButton();

        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyCaptchaField(),"Error message does not contain message about empty captcha field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageIncorrectEmailField(),"Error message does not contain message about incorrect email field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyNameField(),"Error message does not contain message about empty name field");
        Assert.assertTrue(Pages.homePage().isErrorContainMessageEmptyTextField(),"Error message does not contain message about empty text field");//Work
    }
}
