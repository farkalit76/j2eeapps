/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.library.test;

import java.util.List;

/**
 *
 * @author 72010995
 */
public interface Library
{

    //create library operation

    void createLibrary(LibraryInfo library) throws LibraryException;

    LibraryInfo getLibraryById(int id) throws LibraryException;

    List<LibraryInfo> getLibraries() throws LibraryException;

    //crate book operation
    void createBook(BookCatalog book) throws LibraryException;

    BookCatalog getBookById(Long id) throws LibraryException;

    List<BookCatalog> getBooks() throws LibraryException;

    int updateBook(BookCatalog book) throws LibraryException;

    int deleteBook(BookCatalog book) throws LibraryException;

    //crate Students operation
    void createStudent(Student student) throws LibraryException;

    Student getStudentById(int id) throws LibraryException;

    List<Student> getStudents() throws LibraryException;
}
