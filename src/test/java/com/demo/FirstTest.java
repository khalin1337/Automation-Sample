package com.demo;

import com.beust.ah.A;
import com.codeborne.selenide.SelenideElement;
import com.demo.Data.Book;
import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Epic("Amazon Test")
@Feature("First serch page test")
@Owner("QA Khalin Yevhen")
public class FirstTest extends BaseTest {

    @Test(description = "FirstTest")
    public void firstTest() {
        String searchWord = System.getProperty("searchWord", "default_value");
        logInfo("searchName is " + searchWord);
        String searchOption = System.getProperty("searchOption", "default_value");
        logInfo("searchCategory is " + searchOption);
        ArrayList<Book> books;
        Book book;

        //Pages.homePage().waitForSearchForm();
        Pages.homePage().selectCategory(searchOption);
        Pages.homePage().search(searchWord);

        books = Pages.resultPage().getBooks();
        book = Pages.productPage().getNeededBook("https://a.co/d/2W0yTbv");
        System.out.println( book.toString() );

        Assert.assertTrue(Actions.bookAktions().booksJavaCheck(books,book),"Books does not contain needed book:");
    }
}
