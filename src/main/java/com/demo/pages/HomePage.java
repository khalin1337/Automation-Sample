package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends PageTools {

    private final By searchingBar = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By categorySelector = By.xpath("//select[@id='searchDropdownBox']");


    public void search(String searchObject) {
        logInfo("Search by name: "+ searchObject);
        typeWithEnter(searchObject, searchingBar);
    }
    public void selectCategory(String searchObject) {
        logInfo("Select category "+ searchObject);
        $(categorySelector).selectOption(searchObject);
    }
    public void waitForSearchForm() {
        waitForElementVisibility(searchingBar);
    }

}