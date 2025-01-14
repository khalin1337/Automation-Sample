package com.demo.pages.RozetkaWeb;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

import java.util.List;

public class ResultPage extends PageTools {

    private final By searchingResults = By.xpath("//li[contains(@class,'catalog-grid__cell')]");
    private final By aggeLimitButton = By.xpath("//input[@class='button button--medium popup-content__button button--green ng-star-inserted']");

    private List<SelenideElement> getResults(){
       return getElementsWithZeroOptionWithWait(1,searchingResults);
    }
    private void passAggeLimit(){
        if(isElementExist(aggeLimitButton))
        click(aggeLimitButton);
    }
    public void clickOnFirstResult(){
        passAggeLimit();
        click(getResults().get(0));
    }
    public boolean isResultsLoad(){
        logInfo("Check for having result on result page");
        return !getResults().isEmpty();
    }
}
