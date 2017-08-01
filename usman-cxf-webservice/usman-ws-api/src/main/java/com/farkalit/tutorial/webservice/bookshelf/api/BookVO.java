/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf.api;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fusman
 */
@XmlRootElement(name = "Book")
public class BookVO implements Serializable {

    private long bookId;
    private String bookName;
    private String author;

    //JAXB required an empty constructor
    public BookVO()
    {
    }

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "BookVO{" + "bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + '}';
    }

}
