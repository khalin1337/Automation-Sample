package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import com.demo.pages.Rozetka.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Rozetka Test")
@Feature("Product page test")
@Owner("QA Khalin Yevhen")
public class ProductPageTest extends BaseTest {

    @Test(dependsOnMethods = "com.demo.Rozetka.SearchTest.searchTest",priority = 2)
    public  void productPageTest() throws InterruptedException {

        Pages.resultPage().clickOnFirstResult();

        Assert.assertTrue(Pages.productPage().isProductTittleContain(Constants.SearchWordRozetka),
                "Product title does not contain searching word: " + Constants.SearchWordRozetka);

    }

}
