package com.demo.core.base;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.core.allure.AllureLogger;
import org.openqa.selenium.MutableCapabilities;
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

public class BrowserStackWebTest extends AllureLogger {
    public RemoteWebDriver driver;
    public String sessionId;
    public static String userName, accessKey;


    public BrowserStackWebTest() {
        userName = System.getenv("BROWSERSTACK_USERNAME");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    }
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public  void setUP(String browser) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> browserStackOptions = new HashMap<>();
        browserStackOptions.put("buildName", "Final");
        browserStackOptions.put("buildIdentifier", "1");
        browserStackOptions.put("os", "Windows");
        browserStackOptions.put("osVersion", "10");
        browserStackOptions.put("browserName", browser);
        browserStackOptions.put("browserVersion", "latest");
        browserStackOptions.put("projectName", "Rozetka");
        capabilities.setCapability("bstack:options", browserStackOptions);
        driver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey)), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
    }
    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }


}
