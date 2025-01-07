package com.demo.pages;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {

    private final By searchingBar = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By categorySelector = By.xpath("//select[@id='searchDropdownBox']");

    public void search(String searchObject) {
        typeWithEnter(searchObject, searchingBar);
    }
    public void selectCategory(String searchObject) {
        selectOption(searchObject, categorySelector);
    }
    public void waitForSearchForm() {
        waitForElementVisibility(searchingBar);
    }

}