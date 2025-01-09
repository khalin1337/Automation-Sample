package com.demo.Rozetka;

import com.codeborne.selenide.Selenide;
import com.demo.core.base.BaseTest;
import org.testng.annotations.Test;
import com.demo.utils.Constants;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public  void searchTest() throws InterruptedException {
        Selenide.open(Constants.URLRTozetka);
        Thread.sleep(1000);
    }

}
