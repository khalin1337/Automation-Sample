package com.demo.pages.Calculator;

import com.demo.actions.Actions;
import com.demo.core.base.PageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageTools {

    private final By startInfoButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private final By plusButton = By.xpath("//android.widget.Button[@text=\"+\"]");
    private final By minusButton = By.xpath("//android.widget.Button[@text=\"-\"]");
    private final By multipleButton = By.xpath("//android.widget.Button[@text=\"×\"]");
    private final By divideButton = By.xpath("//android.widget.Button[@text=\"÷\"]");
    private final By equalButton = By.xpath("//android.widget.Button[@text=\"=\"]");
    private final By clearButton = By.xpath("//android.widget.Button[@text=\"AC\"]");
    private final By textField = By.xpath("//android.widget.EditText[@resource-id=\"com.sourav.mohanty.calculator:id/result\"]");
    private final By resultField = By.xpath("//android.widget.EditText[@resource-id=\"com.sourav.mohanty.calculator:id/newNumber\"]");


    public String getResult() {
        return getElementText(resultField);
    }
    public void clickStartInfoButton() {
        click(startInfoButton);
    }
    protected void clickClearButton() {
        click(clearButton);
    }
    protected void clickEqualButton() {
        click(equalButton);
    }
    protected void fillTextField(String value) {
        typeWithoutWipe(value,textField);
    }
    protected void clickPlusButton() {
        click(plusButton);
    }
    protected void clickMinusButton() {
        click(minusButton);
    }
    protected void clickMultipleButton() {
        click(multipleButton);
    }
    protected void clickDivideButton() {
        click(divideButton);
    }

    private void summaryOperation(String value1, String value2) {
        fillTextField(value1);
        clickPlusButton();
        fillTextField(value2);
        clickEqualButton();
    }
    private void subtractionOperation(String value1, String value2) {
        fillTextField(value1);
        clickMinusButton();
        fillTextField(value2);
        clickEqualButton();
    }
    private void multiplicationOperation(String value1, String value2) {
        fillTextField(value1);
        clickMultipleButton();
        fillTextField(value2);
        clickEqualButton();
    }
    private void divideOperation(String value1, String value2) {
        fillTextField(value1);
        clickDivideButton();
        fillTextField(value2);
        clickEqualButton();
    }
    public String complexOperation(String expression) {
        return Actions.calculatorActions().doExpression(expression);
    }
}
