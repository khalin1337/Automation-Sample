package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import com.demo.pages.Rozetka.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.demo.utils.Constants;
@Epic("Rozetka Test")
@Feature("Serch page test")
@Owner("QA Khalin Yevhen")
public class RozetkaTest extends BrowserStackTest {

    @Test(priority = 1)
    @Parameters({"searchWord"})
    public  void searchTest(String searchWord) throws InterruptedException {
        Selenide.open(Constants.URLRozetka);
        //Constants.SearchWordRozetka = System.getProperty("searchWord", "Iphone 16");
        logInfo("searchWard is " + searchWord);

        Pages.homePage().searchByText(searchWord);

        Assert.assertTrue(Pages.resultPage().isResultsLoad(),"Result on page was not loaded");
    }
    @Test(dependsOnMethods = "searchTest",priority = 2)
    @Parameters({"searchWord"})
    public  void productPageTest(String searchWord) throws InterruptedException {

        Pages.resultPage().clickOnFirstResult();

        Assert.assertTrue(Pages.productPage().isProductTittleContain(searchWord),
                "Product title does not contain searching word: " + searchWord);

    }
    @Test(dependsOnMethods = "productPageTest",priority = 3)
    @Parameters({"searchWord"})
    public  void addingToShoppingCartTest(String searchWord) {

        Pages.productPage().clickOnByuButton();
        boolean titleCheck = Pages.cartPage().isCartPageContain(searchWord);
        Pages.cartPage().clickOnContinueButton();

        Assert.assertTrue(titleCheck,"Cart page do not contain keyword: " + searchWord);
    }
    @Test(dependsOnMethods = "addingToShoppingCartTest",priority = 4)
    public  void deletingFromShoppingCartTest() throws InterruptedException {

        Pages.productPage().clickCartButton();
        Pages.cartPage().clickOnMenuToggleButton();
        Pages.cartPage().clickOnDeleteButton();

        Assert.assertTrue(Pages.cartPage().isCartIsEmpty(),"Shopping cart is not empty");
    }
}
