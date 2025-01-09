package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.pages.Rozetka.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Rozetka Test")
@Feature("Adding to shopping cart test")
@Owner("QA Khalin Yevhen")
public class AddingToShoppingCartTest {

    @Test(dependsOnMethods = "com.demo.Rozetka.ProductPageTest.productPageTest",priority = 3)
    public  void addingToShoppingCartTest() throws InterruptedException {

        Pages.productPage().clickOnByuButton();
        boolean titleCheck = Pages.cartPage().isCartPageContain(Constants.SearchWordRozetka);
        Pages.cartPage().clickOnContinueButton();

        Assert.assertTrue(titleCheck,"Cart page do not contain keyword: " + Constants.SearchWordRozetka);
    }
}
