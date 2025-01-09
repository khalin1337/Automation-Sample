package com.demo.Rozetka;

import com.demo.pages.Rozetka.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Rozetka Test")
@Feature("Deleting product from shopping cart test")
@Owner("QA Khalin Yevhen")
public class DeletingFromShoppingCartTest {
    @Test(dependsOnMethods = "com.demo.Rozetka.AddingToShoppingCartTest.addingToShoppingCartTest",priority = 4)
    public  void deletingFromShoppingCartTest() throws InterruptedException {

        Pages.productPage().clickCartButton();
        Pages.cartPage().clickOnMenuToggleButton();
        Pages.cartPage().clickOnDeleteButton();

        Assert.assertTrue(Pages.cartPage().isCartIsEmpty(),"Shopping cart is not empty");
    }
}
