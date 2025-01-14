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
        erMassage = "Result page was not loaded";

        Pages.homePage().startApp();
        Pages.homePage().clickSearchOption();
        Pages.homePage().searchByKeyWord(keyword);
        result = Pages.productPage().isResultPageLoad();

        Assert.assertTrue(result,erMassage);
    }
    @Test(priority = 2,dependsOnMethods = "searchTest")
    public void productPageTest() throws InterruptedException {
        erMassage = "Product title does not contain searching word: " + keyword;

        Pages.productPage().selectResultByNumber(1);
        result = Pages.productPage().isProductNameContainsWord(keyword);

        Assert.assertTrue(result,erMassage);
    }
    @Test(priority = 3,dependsOnMethods = "productPageTest")
    public void productNameInCartTest() throws InterruptedException {
        erMassage = "Cart page do not contain keyword: " + keyword;

        Pages.productPage().addProductToCart();
        Pages.productPage().openCart();
        result = !Pages.cartPage().isProductNameContainsWord(keyword);

        Assert.assertTrue(result,erMassage);
    }
    @Test(priority = 4,dependsOnMethods = "productNameInCartTest")
    public void deletingFromShoppingCartTest() throws InterruptedException {
        erMassage = "Cart is not empty";

        Pages.cartPage().deleteProductFromCart();
        result = Pages.cartPage().isCartEmpty();

        Assert.assertTrue(result,erMassage);
    }

}
