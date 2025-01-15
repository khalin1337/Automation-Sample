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
    private void clickClearButton() {
        click(clearButton);
    }
    private void clickEqualButton() {
        click(equalButton);
    }
    private void fillTextField(String value) {
        typeWithoutWipe(value,textField);
    }
    private void clickPlusButton() {
        click(plusButton);
    }
    private void clickMinusButton() {
        click(minusButton);
    }
    private void clickMultipleButton() {
        click(multipleButton);
    }
    private void clickDivideButton() {
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
    public String randomFourNumbersTest(){
        List<String> numbers = Actions.restAssureActions().getRandomNumbers("100","1000","4");
        return complexOperation(String.format("%s - %s + %s * %s", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)));
    }
    private String complexOperation(String expression) {
        //Split the expressions on tokens(Operands and operators)
        List<String> tokens = new ArrayList<>(List.of(expression.split(" ")));
        String result="";

        //Do a multiplication and divide operations
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/")) {
                String leftOperand = tokens.get(i - 1);
                String rightOperand = tokens.get(i + 1);

                fillTextField(leftOperand);
                if (token.equals("*")) {
                    clickMultipleButton();
                } else {
                    clickDivideButton();
                }
                fillTextField(rightOperand);
                clickEqualButton();

                result = getResult();
                tokens.set(i - 1, result);
                tokens.remove(i);
                tokens.remove(i);
                i -= 1;
                clickClearButton();
            }
        }

        //Do a summary and subtraction operations
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("+") || token.equals("-")) {
                String leftOperand = tokens.get(i - 1);
                String rightOperand = tokens.get(i + 1);

                fillTextField(leftOperand);
                if (token.equals("+")) {
                    clickPlusButton();
                } else {
                    clickMinusButton();
                }
                fillTextField(rightOperand);
                clickEqualButton();

                result = getResult();
                tokens.set(i - 1, result);
                tokens.remove(i);
                tokens.remove(i);
                i -= 1;
                clickClearButton();
            }
        }
        return result;
    }
}
