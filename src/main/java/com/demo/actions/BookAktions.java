package com.demo.actions;

import com.demo.Data.Book;

import java.util.ArrayList;

public class BookAktions {

    public String formatAuthorString(String authorsNames){
        String temp = authorsNames;
        if(!temp.contains("(Author)")) {
            temp = temp.replace("and", ",");
            temp = temp.replace(", et al.", "");
            int endIndex = authorsNames.length();
            if (temp.contains("|")) endIndex = temp.lastIndexOf("|");
            temp = authorsNames.substring(authorsNames.indexOf("by") + 2, endIndex);
        }
        else{
           temp = temp.replace(" (Author)","");
           temp = temp.replace("by","");
           temp = temp.trim();
        }
        return temp.trim();
    }
    public boolean booksJavaCheck(ArrayList<Book> books, Book book) {
        return books.contains(book);
    }
}
