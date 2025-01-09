package com.demo.core.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.demo.core.allure.AllureLogger;
import com.demo.core.config.SelenideConfig;
import com.demo.utils.Constants;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {

    @BeforeSuite(alwaysRun = true, description = "Opening web browser...")
    public void setUp() throws Exception {

        logInfo("Creating web driver configuration..."); //test
        SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        configLog(this.getClass().getSimpleName());
        logInfo("Open browser...");
        //Selenide.open(Constants.URL);
    }

    @AfterSuite(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        logInfo("Web driver closed!");
    }
}
