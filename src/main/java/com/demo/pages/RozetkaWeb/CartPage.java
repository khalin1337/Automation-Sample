package com.demo.pages.RozetkaWeb;

import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

public class CartPage extends PageTools {

    private final By menuToggleButton = By.xpath("//button[contains(@id,'cartProductActions')]");
    private final By deleteButton = By.xpath("//rz-trash-icon//button");
    private final By emptyCartHeading = By.xpath("//h4[@class='cart-dummy__heading']");
    private final By cartProductTile = By.xpath("//span[contains(@class,'cart-product__title')]");
    private final By cartContinueButton = By.xpath("//button[contains(@class,'cart-footer__continue')]");

    public void clickOnMenuToggleButton(){
        waitForElementClickable(menuToggleButton);
        click(menuToggleButton);
    }
    public void clickOnContinueButton(){
        waitForElementVisibility(cartContinueButton);
        click(cartContinueButton);
    }
    private String getCartProductTile(){
        waitForElementVisibility(cartProductTile);
        return getElementText(cartProductTile);
    }
    public void clickOnDeleteButton(){
        waitForElementVisibility(deleteButton);
        click(deleteButton);
    }
    public boolean isCartIsEmpty() {
            return getElementText(emptyCartHeading).equals("Кошик порожній");
    }
    public boolean isCartPageContain(String value) {
        return getCartProductTile().toLowerCase().contains(value.toLowerCase());
    }

}
