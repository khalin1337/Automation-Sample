package com.demo.core.base;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.actions.Actions;
import com.demo.core.allure.AllureLogger;
import com.demo.utils.SelenideTools;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.opentest4j.AssertionFailedError;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserStackAppTest extends AllureLogger {

    public AndroidDriver driver;
    protected boolean result;
    protected String erMassage;
    public static String userName, accessKey;


    public BrowserStackAppTest() {
        userName = System.getenv("BROWSERSTACK_USERNAME");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    }
    @BeforeClass(alwaysRun = true)
    //@Parameters("browser")
    public  void setUP() throws MalformedURLException {
        MutableCapabilities capabilities = new UiAutomator2Options();
        HashMap<String, String> browserStackOptions = new HashMap<>();
        browserStackOptions.put("buildName", "Final");
        browserStackOptions.put("buildIdentifier", "1");
        browserStackOptions.put("platformName", "Android");
        browserStackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
        browserStackOptions.put("platformVersion", "12.0");
        browserStackOptions.put("projectName", "Rozetka");
        browserStackOptions.put("interactiveDebugging", "false");
        browserStackOptions.put("networkProfile", "4g-lte-advanced-good");
        capabilities.setCapability("bstack:options", browserStackOptions);
        capabilities.setCapability("app","bs://e1be51cad4af13c0b61bdcce32b623b2f69678bf");
        driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey)), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
        SelenideTools.sleep(3);
    }
    @AfterClass
    public void tearDown(){
            if(result)
                Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, true, "Test completed successfully");
            else
                Actions.browserStackActions().setAppTestStatus
                        (userName, accessKey, false, erMassage);
            SelenideTools.sleep(3);
            closeWebDriver();

    }
}
