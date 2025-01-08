package com.demo.actions;

import com.demo.Data.Book;
import com.demo.core.base.PageTools;

import java.util.ArrayList;

public class BookActions extends PageTools {

    public String formatAuthorString(String authorsNames){
        String temp = authorsNames;
        if(temp.contains("(Author)")) {
            temp = temp.replace(" (Author)","");
            temp = temp.replace("by","");
            temp = temp.trim();

        }
        else {
            temp = temp.replace(" and", ",");
            temp = temp.replace(", et al.", "");
            int endIndex = temp.length();
            if (temp.contains("|")) endIndex = temp.lastIndexOf("|");
            temp = temp.substring(temp.indexOf("by") + 2, endIndex);
        }
        return temp.trim();
    }
    public boolean booksJavaCheck(ArrayList<Book> books, Book book) {
        logInfo("Check if list of books contains needed book");
        return books.contains(book);
    }
}
