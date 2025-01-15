package com.demo.actions;

import com.demo.pages.Calculator.HomePage;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActions extends HomePage {
    public String doExpression(String expression){
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
