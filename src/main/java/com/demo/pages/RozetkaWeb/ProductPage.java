package com.demo.pages.RozetkaWeb;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class ProductPage extends PageTools {

    private final By productTittle = By.xpath("//h1");
    private final By byuButton = By.xpath("//button[contains(@class,'buy-button')]");
    private final By cartButton = By.xpath("//button[@class='header-cart__button']");

    public void clickOnByuButton(){
        click(byuButton);
    }
    public void clickCartButton(){
        waitForElementVisibility(cartButton);
        click(cartButton);
    }
    public  boolean isProductTittleContain(String value){
        logInfo("Check that product tittle" + getProductTittle() + " contain keyword " + value);
        System.out.println("Check that product tittle " + getProductTittle() + " contain keyword " + value);
        return getProductTittle().toLowerCase().contains(value.toLowerCase());
    }
    private String getProductTittle(){
        waitForElementPresent(productTittle);
        return getElementText(productTittle);
    }
}
