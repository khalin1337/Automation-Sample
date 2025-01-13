package com.demo.pages.GoogleSearch;

import com.codeborne.selenide.*;
import com.demo.core.base.PageTools;
import org.openqa.selenium.*;

import java.util.List;

public class ResultPage extends PageTools {

    private final By resultTitles = By.xpath("//div[@class='MjjYud']//a[@jsname]//h3");

    public List<String> getAllResults(){
        return getElementsText(resultTitles);
    }
    public boolean isAllResultsContainsSearchWord(String value){
        return getAllResults().stream().allMatch(o -> o.toLowerCase().contains(value.toLowerCase()));
    }
}
