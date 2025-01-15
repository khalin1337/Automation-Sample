package com.demo.Calculator;

import com.demo.Data.RestAssureHelper;
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

        int number1 = RestAssureHelper.getRandomNumber("100","1000");
        int number2 = RestAssureHelper.getRandomNumber("100","1000");
        int number3 = RestAssureHelper.getRandomNumber("100","1000");
        int number4 = RestAssureHelper.getRandomNumber("100","1000");
        int actualResult = number1 - number2 + (number3 * number4);

        String result = Pages.homePage().complexOperation(String.format("%s - %s + %s * %s", number1, number2, number3, number4));

        Assert.assertEquals(result,Integer.toString(actualResult) + ".0");
    }
}
