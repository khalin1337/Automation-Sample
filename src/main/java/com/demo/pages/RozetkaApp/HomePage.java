package com.demo.pages.RozetkaApp;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {

    private final By notificationButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]");
    private final By advertisementButton = By.xpath("//android.widget.ImageView[@resource-id=\"ua.com.rozetka.shop:id/iv_close\"]");
    private final By searchOption = By.xpath("//android.widget.TextView[@resource-id=\"ua.com.rozetka.shop:id/tv_search\"]");
    private final By searchField = By.xpath("//android.widget.EditText[@resource-id=\"ua.com.rozetka.shop:id/et_query\"]");
    private final By searchCategory = By.xpath("(//android.widget.ImageView[@resource-id=\"ua.com.rozetka.shop:id/iv_left\"])");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вгору\"]");

    private void clickAdvertisementButton(){
        if(isElementExist(advertisementButton)) {
            waitForElementClickable(advertisementButton);
            click(advertisementButton);
        }
    }
    public void clickSearchOption(){
        waitForElementClickable(searchOption);
        click(searchOption);
    }
    private void clickBackButton() {
        waitForElementClickable(backButton);
        click(backButton);
    }
    private void clickNotificationButton() {
        if(isElementExist(notificationButton)) {
            waitForElementClickable(notificationButton);
            click(notificationButton);
        }
    }
    public void startApp() {
        clickAdvertisementButton();
        clickNotificationButton();
    }
    public void selectSearchCategoryByNumber(int value){
        click(searchCategory,"["+ value + "]");
    }
    public void searchByKeyWord(String value){
        clickBackButton();
        waitForElementVisibility(searchField);
        click(searchField);
        typeWithoutWipe(value,searchField);
        selectSearchCategoryByNumber(1);
    }

}
