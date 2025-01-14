package com.demo;

import com.codeborne.selenide.Selenide;
import com.demo.Data.Book;
import com.demo.actions.Actions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Amazon.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Epic("Amazon Test")
@Feature("First serch page test")
@Owner("QA Khalin Yevhen")
public class FirstTest extends BaseTest {

    @Test(description = "FirstTest")
    public void firstTest() {
        Selenide.open(Constants.URLAmazon);
        String searchWord = System.getProperty("searchWord", "Java");
        logInfo("searchName is " + searchWord);
        String searchOption = System.getProperty("searchOption", "Books");
        logInfo("searchCategory is " + searchOption);
        ArrayList<Book> books;
        Book book;

        //Pages.homePage().waitForSearchForm();
        Pages.homePage().selectCategory(searchOption);
        Pages.homePage().search(searchWord);

        books = Pages.resultPage().getBooks();
        book = Pages.productPage().getNeededBook("https://a.co/d/88yKPcb");
        //System.out.println( book.toString() );

        Assert.assertTrue(Actions.bookActions().booksJavaCheck(books,book),"Books does not contain needed book:");
    }
}
