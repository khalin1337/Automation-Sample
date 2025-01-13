package com.demo.pages.GoogleSearch;

import com.demo.core.base.PageTools;
import org.openqa.selenium.*;

public class HomePage extends PageTools {

    private final By searchInput = By.xpath("//textarea[@name='q']");
    private final By cookieButton = By.xpath("//button[@id='W0wltc']");

    public void searchByWord(String value){
        waitForElementVisibility(cookieButton);
        click(cookieButton);
        waitForElementVisibility(searchInput);
        typeWithEnter(value,searchInput);
    }
}
