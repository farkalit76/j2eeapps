/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf;

import com.farkalit.tutorial.webservice.bookshelf.api.BookVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fusman
 */
public class HashDB {

    private static BookVO book;

    private static List<BookVO> bookList = new ArrayList<>();

    public static void insertBook(BookVO book) {
        HashDB.book = book;
        bookList.add(book);
    }

    public static BookVO getBookInfo(String title) {
        if (bookList != null && bookList.size() > 0) {
            System.out.println("List Size:" + bookList.size());
            for (BookVO bk : bookList) {
                if (bk.getBookName().equals(title)) {
                    return bk;
                }
            }
        }

        return new BookVO();
    }

}
