/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf;

import com.farkalit.tutorial.webservice.bookshelf.api.BookVO;
import com.farkalit.tutorial.webservice.bookshelf.api.IBookshelfService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService(portName = "BookshelfPort", name = "BookshelfEndpoint", serviceName = "BookshelfService", targetNamespace = "http://tutorial.vertexgroup.com/ws/bookshelf")
public class EnterpriseBookshelfService implements IBookshelfService {

    @WebMethod
    @Override
    public String insertBook(BookVO bookVO)
    {
        HashDB.insertBook(bookVO);
        System.out.println("Book Inserted");
        return "Book with name : " + bookVO.getBookName() + " is now available on the shelf";
    }

    @WebMethod
    @Override
    public BookVO getBookInfo(@WebParam(name = "title") String title)
    {
        BookVO book = HashDB.getBookInfo(title);
        System.out.println("BOOK:" + book.toString());
        return book;
    }

}
