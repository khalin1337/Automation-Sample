package com.demo.actions;

import com.demo.pages.Pages;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TestmatickActions {



    public String doExpression(String expression){
        List<String> tokens = new ArrayList<>(List.of(expression.split(" ")));
        String result="";
        if (tokens.get(1).equals("+"))
            result = Integer.toString(parseInt(tokens.get(0)) + parseInt(tokens.get(2)));
        else
            result = Integer.toString(parseInt(tokens.get(0)) - parseInt(tokens.get(2)));
        return result;
    }
}