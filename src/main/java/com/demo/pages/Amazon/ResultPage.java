package com.demo.pages.Amazon;

import com.codeborne.selenide.*;
import com.demo.Data.Book;
import com.demo.actions.Actions;
import com.demo.core.base.PageTools;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ResultPage extends PageTools {

    private final By results = By.xpath("//div[@role='listitem']");
    private final By resultsPrises = By.xpath(".//div[@class='a-row']/a[not(contains(span[text()],'to rent'))]/span[@class='a-price']/span[@class='a-offscreen']");
    private  final By resultsName = By.xpath(".//h2//span");
    private  final By resultBestsellerMark = By.xpath(".//div[contains(@class,'s-list-status-badge-container')]");
    private  final By resultAuthorsName = By.xpath(".//div[@class='a-row' and span[contains(text(),'by')]]");

    private List<SelenideElement> getResults(){
        return getElements(results);
    }
    private String getResultName(SelenideElement result){
        return getChildElementText(result,resultsName);
    }
    private ArrayList<String> getResultPrices(SelenideElement result){
        return (ArrayList<String>) getChildElementsText(result,resultsPrises);
    }
    private boolean getResultBestsellerMark(SelenideElement result){
        return !getChildElementText(result,resultBestsellerMark).isEmpty();
    }
    private String getResultAuthorsName(SelenideElement result){
        return  Actions.bookAktions().formatAuthorString(getChildElementText(result,resultAuthorsName));
    }
    public ArrayList<Book> getBooks(){
        logInfo("Get all results");
        ArrayList<Book> books = new ArrayList<Book>();
        for(SelenideElement result : getResults()){
            books.add(new Book(getResultName(result),getResultBestsellerMark(result),getResultPrices(result),getResultAuthorsName(result)));
            //System.out.println(books.get(books.size()-1).toString());
        }
        return books;
    }

}
