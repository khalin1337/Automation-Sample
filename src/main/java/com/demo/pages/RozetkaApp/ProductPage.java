package com.demo.pages.RozetkaApp;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class ProductPage extends PageTools {
    private final By result = By.xpath("//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/section_offer_tv_title\"]");
    private final By productName = By.xpath("(//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/tv_title\"])[1]");
    private final By cartButton = By.xpath("//android.widget.ImageView[@resource-id = \"ua.com.rozetka.shop:id/iv_toolbar_cart\"]");
    private final By addToCartButton = By.xpath("//android.widget.ImageView[@resource-id=\"ua.com.rozetka.shop:id/iv_cart\"]");

    public void selectResultByNumber(int value){
        click(result,"[" + value + "]");
    }
    public boolean isProductNameContainsWord(String value){
        return getElementText(productName).contains(value);
    }
    public boolean isResultPageLoad(){
        return isElementExist(result);
    }

    public void addProductToCart() {
        waitForElementClickable(addToCartButton);
        click(addToCartButton);
    }
    public void openCart() {
        waitForElementClickable(cartButton);
        click(cartButton);
    }
}
