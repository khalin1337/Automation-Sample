package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import com.demo.utils.Constants;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test(dependsOnMethods = "com.demo.Rozetka.SearchTest.searchTest",priority = 2)
    public  void productPageTest() throws InterruptedException {
        Selenide.open(Constants.URLRTozetka +"/qweqweqweq");
        Thread.sleep(1000);
    }

}
