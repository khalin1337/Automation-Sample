package com.demo.pages.RozetkaApp;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class CartPage extends PageTools {

    private final By productName = By.xpath("(//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/tv_title\"])[1]");
    private final By menuButton = By.xpath("(//android.widget.ImageView[@resource-id=\"ua.com.rozetka.shop:id/iv_menu\"])[1]");
    private final By deleteButton = By.xpath("(//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/title\"])[2]");
    private final By emptyBadge = By.xpath("//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/empty_base_tv_title\"]");

    public boolean isProductNameContainsWord(String value){
        return getElementText(productName).contains(value);
    }
    public void deleteProductFromCart() {
        waitForElementClickable(menuButton);
        click(menuButton);
        click(deleteButton);
    }
    public boolean isCartEmpty() {
        return isElementExist(emptyBadge);
    }

}
