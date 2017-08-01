/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf.client.test;

import com.farkalit.tutorial.webservice.bookshelf.client.BookshelfEndpointFactory;
import com.vertexgroup.tutorial.ws.bookshelf.BookVO;
import com.vertexgroup.tutorial.ws.bookshelf.BookshelfEndpoint;

/**
 *
 * @author fusman
 */
public class BookshelfEndpointTest {

    public static void main(String[] args)
    {
        BookshelfEndpoint endpoint = BookshelfEndpointFactory.create();
        BookVO book = new BookVO();
        book.setBookId(123);
        book.setAuthor("Arthor");
        book.setBookName("J2EE");
        String insertBook = endpoint.insertBook(book);
        System.out.println("book added:" + insertBook);

        book = new BookVO();
        book.setBookId(1234);
        book.setAuthor("Farkalit");
        book.setBookName("Hibernate");
        endpoint.insertBook(book);
        System.out.println("another book added:" + insertBook);

        BookVO book1 = endpoint.getBookInfo("J2EE");
        System.out.println("book1:" + book1.getAuthor() + "," + book1.getBookId());
        BookVO book2 = endpoint.getBookInfo("Hibernate");
        System.out.println("book2:" + book2.getAuthor() + "," + book2.getBookId());
    }

}
