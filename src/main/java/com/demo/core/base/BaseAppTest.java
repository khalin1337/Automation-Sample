package com.demo.core.base;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.actions.Actions;
import com.demo.core.allure.AllureLogger;
import com.demo.utils.SelenideTools;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseAppTest extends AllureLogger {

    @BeforeClass(alwaysRun = true)
    //@Parameters("browser")
    public  void setUP() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setPlatformVersion("15");
        options.setApp("C:\\Users\\User\\Downloads\\app-debug.apk");
        //GitHub to .APK file https://github.com/Sourav0010/Calculator/releases/tag/v2.0.0
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
        SelenideTools.sleep(3);
    }

    @AfterClass
    public void tearDown(){
        SelenideTools.sleep(3);
        closeWebDriver();
    }
}
