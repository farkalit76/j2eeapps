/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.library.test;

import com.farkalit.util.HibSessionManager;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class LibraryDao implements Library
{

    private static final SessionFactory factory = HibSessionManager.getSessionFactory();

    @Override
    public void createLibrary(LibraryInfo library) throws LibraryException
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.persist(library);
            trans.commit();//close transaction

        }
        catch (HibernateException e)
        {
            System.err.println("Create Library Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public LibraryInfo getLibraryById(int id) throws LibraryException
    {
        LibraryInfo library = null;
        Session session = null;
        try
        {
            session = factory.openSession();
            Object obj = session.load(LibraryInfo.class, id);
            library = (LibraryInfo) obj;
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return library;
    }

    @Override
    public List<LibraryInfo> getLibraries() throws LibraryException
    {
        List<LibraryInfo> library = new ArrayList<>();
        Session session = null;
        try
        {
            session = factory.openSession();
            Query query = session.createQuery("from LibraryInfo");
            library = query.list();
        }
        catch (HibernateException e)
        {
            System.err.println("Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return library;
    }

    @Override
    public void createBook(BookCatalog book) throws LibraryException
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.persist(book);
            trans.commit();//close transaction

        }
        catch (HibernateException e)
        {
            System.err.println("Create Book Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public BookCatalog getBookById(Long id) throws LibraryException
    {
        BookCatalog book = null;
        Session session = null;
        try
        {
            session = factory.openSession();
            Object obj = session.get(BookCatalog.class,id);
            book = (BookCatalog) obj;
        }
        catch (HibernateException e)
        {
            System.err.println("Book By ID Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<BookCatalog> getBooks() throws LibraryException
    {
        List<BookCatalog> books = new ArrayList<>();
        Session session = null;
        try
        {
            session = factory.openSession();
            Query query = session.createQuery("from BookCatalog");
            books = query.list();
        }
        catch (HibernateException e)
        {
            System.err.println("books Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return books;
    }

    @Override
    public int updateBook(BookCatalog book) throws LibraryException
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.update(book);
            trans.commit();//close transaction

        }
        catch (HibernateException e)
        {
            System.err.println("Update Book Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return 1;
    }

    @Override
    public int deleteBook(BookCatalog book) throws LibraryException
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.delete(book);
            trans.commit();//close transaction

        }
        catch (HibernateException e)
        {
            System.err.println("Delete Book Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return 1;
    }

    @Override
    public void createStudent(Student student) throws LibraryException
    {
        Session session = null;
        try
        {
            session = factory.openSession();
            //Open transaction
            Transaction trans = session.beginTransaction();
            session.persist(student);
            trans.commit();//close transaction

        }
        catch (HibernateException e)
        {
            System.err.println("Create student Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public Student getStudentById(int id) throws LibraryException
    {
        Student student = null;
        Session session = null;
        try
        {
            session = factory.openSession();
            Object obj = session.load(LibraryInfo.class, id);
            student = (Student) obj;
        }
        catch (HibernateException e)
        {
            System.err.println("students Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List<Student> getStudents() throws LibraryException
    {
        List<Student> students = new ArrayList<>();
        Session session = null;
        try
        {
            session = factory.openSession();
            Query query = session.createQuery("from Student");
            students = query.list();
        }
        catch (HibernateException e)
        {
            System.err.println("students Error:" + e.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return students;
    }

    /**
     * Closing the Session Factory
     */
    public static void closeSessionFactory()
    {
        HibSessionManager.shutdown();
    }
}
