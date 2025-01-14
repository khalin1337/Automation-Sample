package com.demo.pages.RozetkaWeb;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {

    private final By searchingFill = By.xpath("//input[contains(@class,'search-form__input')]");
    private final By homePageRecommendations = By.xpath("//rz-goods-sections-best");

    public void searchByText(String value){
        waitForElementVisibility(homePageRecommendations);
        typeWithEnter(value,searchingFill);
    }

}
