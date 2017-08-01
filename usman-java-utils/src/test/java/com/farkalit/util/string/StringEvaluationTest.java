/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.string;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fusman
 */
public class StringEvaluationTest {
    
    StringEvaluation eval= null;
    public StringEvaluationTest()
    {
    }
    
    @Before
    public void setUp()
    {
        eval = new StringEvaluation();
    }

    /**
     * Test of main method, of class StringEvaluation.
     */
    @Test
    public void stringImmutableTest()
    {
        System.out.println("stringImmutable");
        String actual = eval.stringImmutable("Usman");
        assertEquals("String message", "HelloUsman", actual);
    }

    /**
     * Test of main method, of class StringEvaluation.
     */
    @Test
    public void stringMutableTest()
    {
        System.out.println("stringMutable");
        String actual = eval.stringMutable("Usman");
        assertEquals("String Mutable message", "HelloUsman", actual);
    }
    /**
     * Test of stringTest method, of class StringEvaluation.
     */
    @Test
    public void testStringTest()
    {
        System.out.println("stringTest");
        StringEvaluation.stringTest();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertTrue("It is false",true);
    }
    
}
