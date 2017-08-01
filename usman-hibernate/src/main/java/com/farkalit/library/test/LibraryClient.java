/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.library.test;

import com.farkalit.util.IdGenerator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class LibraryClient
{

    public static void main(String[] args)
    {
        LibraryDao dao = new LibraryDao();
        try
        {
            //Create a new Library & display all
            //createLibrary(dao);
            listLibraries(dao);

            //Create new Book Catalog and display all
            createBook(dao);
            getBookById(dao);
            updateBook(dao);
            listBooks(dao);
            deleteBook(dao);

            //Create new Student and display all 
            //createStudent(dao);
            listStudents(dao);

            //close session factory
            LibraryDao.closeSessionFactory();
        }
        catch (LibraryException ex)
        {
            Logger.getLogger(LibraryClient.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR:" + ex.getMessage());
        }

    }

    public static LibraryInfo newLibrary()
    {
        LibraryInfo lib = new LibraryInfo();
        lib.setId(IdGenerator.getRandomNum());
        lib.setName("New Library");
        lib.setAddress("New Delhi");
        lib.setEstablished(new Date());
        lib.setFounder("Mr. A.P.J. Kalam");

        return lib;
    }

    public static void createLibrary(LibraryDao dao) throws LibraryException
    {
        //Create a new Library
        LibraryInfo lib = newLibrary();
        dao.createLibrary(lib);   
        System.out.println("library created for ID:"+lib.getId());
    }

    public static void listLibraries(LibraryDao dao) throws LibraryException
    {
        //Display all libraries
        List<LibraryInfo> librarys = dao.getLibraries();
        System.out.println("Library Count:"+librarys.size());
        Iterator<LibraryInfo> iterator = librarys.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }

    public static BookCatalog newBookCatalog()
    {
        BookCatalog book = new BookCatalog();
        book.setId(IdGenerator.getRandomNum());
        book.setName("Java Core");
        book.setAuthor("Patric Naughton");
        book.setPrintingYear(new Date());
        book.setPrice(230.00f);
        book.setPages(566);
        book.setAvailable(10); //available copy numbers
        return book;
    }

    public static void createBook(LibraryDao dao) throws LibraryException
    {
        final BookCatalog book = newBookCatalog();
        dao.createBook(book);
        System.out.println("Book catalog created for ID:" + book.getId());
    }

    public static void getBookById(LibraryDao dao) throws LibraryException
    {      
        BookCatalog book = dao.getBookById(2167L);
        System.out.println("Book By Id:"+book.toString());
    }
    
    public static void listBooks(LibraryDao dao) throws LibraryException
    {
        //Display all libraries
        List<BookCatalog> books = dao.getBooks();
        System.out.println("Books Count:"+books.size());
        Iterator<BookCatalog> iterator2 = books.iterator();
        while (iterator2.hasNext())
        {
            System.out.println(iterator2.next().toString());
        }
    }

    public static void updateBook(LibraryDao dao) throws LibraryException
    {
        List<BookCatalog> books = dao.getBooks();
        BookCatalog book = books.get(1);
        book.setName("Oracle Understanding");
        book.setPrice(339.00f);
        dao.updateBook(book);
        System.out.println("Book catalog updated for ID:" + book.getId());
    }

    public static void deleteBook(LibraryDao dao) throws LibraryException
    {
        List<BookCatalog> books = dao.getBooks();
        BookCatalog book = books.get(0);
        dao.deleteBook(book);
        System.out.println("Book catalog deleted for ID:" + book.getId());
    }

    public static Student newStudent()
    {
        Student student = new Student();
        student.setId(IdGenerator.getRandomNum());
        student.setFirstName("Farkalit");
        student.setLastName("Usman");
        student.setBirthDate(new Date());
        student.setSex('M');
        student.setClassName("MSc");
        student.setSection("Mathematics");
        student.setAdmissionYear(new Date());
        return student;
    }

    public static void createStudent(LibraryDao dao) throws LibraryException
    {
        Student std = newStudent();
        dao.createStudent(std);
        System.out.println("Students created for id:" + std.getId());
    }

    public static void listStudents(LibraryDao dao) throws LibraryException
    {
        //Display all students
        List<Student> students = dao.getStudents();
        System.out.println("Student Count:"+students.size());
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }
}
