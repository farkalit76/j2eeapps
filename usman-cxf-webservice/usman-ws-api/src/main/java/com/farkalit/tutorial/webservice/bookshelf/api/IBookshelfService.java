/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf.api;

import javax.jws.WebParam;

/**
 *
 * @author fusman
 */
public interface IBookshelfService {

    String insertBook(BookVO book);

    BookVO getBookInfo(String title);
}
