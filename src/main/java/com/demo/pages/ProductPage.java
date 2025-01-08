package com.demo.pages;

import com.demo.Data.Book;
import com.demo.actions.Actions;
import com.demo.core.base.PageTools;
import org.openqa.selenium.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPage extends PageTools {

    private final By productName = By.xpath("//span[@id='productTitle']");
    private final By productPrice = By.xpath("//span/a//span[@class='a-size-base a-color-secondary']");
    private final By productAuthorsNames = By.xpath("//div[@id='bylineInfo']");
    private final By productBestsellerMark = By.xpath("//div[@class='zg-badge-wrapper']");

    private String getName(){
        return getElementText(productName);
    }
    private String getAuthorsNames(){
        return Actions.bookAktions().formatAuthorString(getElementText(productAuthorsNames));
    }
    private ArrayList<String> getProductPrice(){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(getElementText(productPrice));
        return temp ;
    }
    private boolean getBestsellerMark(){
        return $(productBestsellerMark).exists();
    }
    public Book getNeededBook(String Url){
        logInfo("Get needed book");
        open(Url);
        return new Book(getName(),getBestsellerMark(),getProductPrice(),getAuthorsNames());
    }
}
