/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fusman
 */
public class AlgebraicCalculatorTest {

    AlgebraicCalculator calc = new AlgebraicCalculator();
    @Test
    public void validationTest()
    {
        double expected = calc.evaluate(null);
        assertEquals(expected, Double.NaN, 0.0);
        double expected2 = calc.evaluate("2*");
        assertEquals(expected2, Double.NaN, 0.0);
    }
    
    @Test
    public void simmpleTest()
    {
        double expected = calc.evaluate("3 / 2");
        assertEquals(expected, 1.5, 0.0);
        double expected2 = calc.evaluate("3 * 2");
        assertEquals(expected2, 6.0, 0.0);
        double expected3 = calc.evaluate("3 - 2");
        assertEquals(expected3, 1.0, 0.0);
        double expected4 = calc.evaluate("3 + 2");
        assertEquals(expected4, 5.0, 0.0);
    }
    
    @Test
    public void expressionTest()
    {
        double expected = calc.evaluate("2 * 2");
        assertEquals(expected, 4.0, 0.0);
        double expected2 = calc.evaluate("5 * 3 + 1 + 6 / 2 +9 * 100");
        assertEquals(expected2, 919.0, 0.0);
        double expected3 = calc.evaluate("5 * 3 + 1 + 6 / 85 +9 * 100");
        assertEquals(expected3, 916.07, 0.01);
        double expected4 = calc.evaluate("6 /2 - 5 * 3 + 1 + 9 * 100");
        assertEquals(expected4, 889.0, 0.0);
    }
}
