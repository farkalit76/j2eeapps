/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf.client.test;

import com.farkalit.tutorial.webservice.bookshelf.api.BookVO;
import com.farkalit.tutorial.webservice.bookshelf.api.IBookshelfService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author fusman
 */
public class BookshelfTest {
    public static void main(String[] args)
    {
        String serviceUrl = "http://localhost:8030/usman-ws-bookshelf/svc/ws/BookshelfControl";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IBookshelfService.class);
        factory.setAddress(serviceUrl);
        IBookshelfService bookService = (IBookshelfService) factory.create();
        //call the methods
        BookVO bk = new BookVO();
        bk.setAuthor("Test");
        bk.setBookName("Java");
        bookService.insertBook(bk);
    }
}
