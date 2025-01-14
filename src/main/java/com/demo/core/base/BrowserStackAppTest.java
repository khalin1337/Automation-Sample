package com.demo.core.base;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.core.allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
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
    public String sessionId;
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
        browserStackOptions.put("interactiveDebugging", "true");
        capabilities.setCapability("bstack:options", browserStackOptions);
        capabilities.setCapability("app","bs://e1be51cad4af13c0b61bdcce32b623b2f69678bf");
        driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey)), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
    }
    /*@BeforeClass(alwaysRun = true)
    //@Parameters("browser")
    public  void setUP() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setPlatformVersion("15");
        options.setApp("C:\\Users\\User\\Downloads\\rozetka-5-51-1.apk");
        //GitHub to .APK file https://github.com/Sourav0010/Calculator/releases/tag/v2.0.0
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
    }*/
    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }

    public static void setTestStatus(String sessionId, String username, String accessKey, boolean isSuccess, String reason) {
        try {
            URL url = new URL("https://api.browserstack.com/automate/sessions/" + sessionId + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String auth = username + ":" + accessKey;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            String status = isSuccess ? "passed" : "failed";
            String body = "{\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}";

            connection.getOutputStream().write(body.getBytes());
            connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void endSession(String sessionId, String username, String accessKey, boolean isSuccess, String reason) {
        setTestStatus(sessionId, username, accessKey, isSuccess, reason);
    }
}
