package com.demo.Rozetka;

import com.demo.actions.Actions;
import com.demo.core.base.BrowserStackAppTest;
import com.demo.pages.RozetkaApp.Pages;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RozetkaAppTest extends BrowserStackAppTest {

    private final String keyword = System.getProperty("keyword","123123");
    @Test(priority = 1)
    public void searchTest() throws InterruptedException {

        Pages.homePage().startApp();
        Pages.homePage().clickSearchOption();
        Pages.homePage().searchByKeyWord(keyword);
        boolean result = Pages.productPage().isResultPageLoad();

        if (!result)
            Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, false, "Result page was not loaded");

        Assert.assertTrue(result,"Result page was not loaded");
    }
    @Test(priority = 2,dependsOnMethods = "searchTest")
    public void productPageTest() throws InterruptedException {

        Pages.productPage().selectResultByNumber(1);
        boolean result = Pages.productPage().isProductNameContainsWord(keyword);

        if (!result)
            Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, false, "Product title does not contain searching word: " + keyword);

        Assert.assertTrue(result,"Product title does not contain searching word: " + keyword);
    }
    @Test(priority = 3,dependsOnMethods = "productPageTest")
    public void productNameInCartTest() throws InterruptedException {

        Pages.productPage().addProductToCart();
        Pages.productPage().openCart();
        boolean result = Pages.cartPage().isProductNameContainsWord(keyword);

        if (!result)
            Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, false, "Cart page do not contain keyword: " + keyword);

        Assert.assertTrue(result,"Cart page do not contain keyword: " + keyword);
    }
    @Test(priority = 4,dependsOnMethods = "productNameInCartTest")
    public void deletingFromShoppingCartTest() throws InterruptedException {

        Pages.cartPage().deleteProductFromCart();
        boolean result = Pages.cartPage().isCartEmpty();

        if (result)
            Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, true, "Test completed successfully");
        else
            Actions.browserStackActions().setAppTestStatus
                    (userName, accessKey, false, "Cart page do not contain keyword: " + keyword);

        Assert.assertTrue(result,"Cart is not empty");
    }

}
