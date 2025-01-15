package com.demo.Calculator;

import com.demo.actions.Actions;
import com.demo.core.base.BaseAppTest;
import com.demo.pages.Calculator.Pages;
import com.demo.utils.SelenideTools;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseAppTest {

    @Test
    public void randomFourNumbersTest() {
        Pages.homePage().clickStartInfoButton();
        String result = Pages.homePage().randomFourNumbersTest();

        Assert.assertNotEquals(result,null, "Result is null");
    }
}
