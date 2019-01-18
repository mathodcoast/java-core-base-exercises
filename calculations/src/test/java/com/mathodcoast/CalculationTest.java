package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CalculationTest {

    @Test
    public void testCalculateValueOfExpression_1(){
        int a = 2, b = 3;

        int result = Calculation.calculateValueOfExpression_1(a,b);
        assertEquals(-94, result);
    }

    @Test
    public void testCalculateValueOfExpression_2(){
        int x = -2;

        double result = Calculation.calculateValueOfExpression_2(x);
        assertEquals(-30, result,0);
    }

    @Test
    public void testCalculateValueOfExpression_3(){
        double x = 1.7;

        double result = Calculation.calculateValueOfExpression_3(x);
        assertEquals(15.39, result,0.0000000001);
    }

    @Test
    public void testCalculateValueOfExpression_4(){
        double x = -2.34;

        double result = Calculation.calculateValueOfExpression_4(x);
        assertEquals(-1.76911, result, 0.00001);
    }

    @Test
    public void testCalculateValueOfExpression_5(){
        double x = 3.6;

        double result = Calculation.calculateValueOfExpression_5(x);
        assertEquals(-156.1276, result, 0.0001);
    }

    @Test
    public void testCalculateValueOfExpression_6(){
        double a = 0.1;
        double b = 0.2;
        double x = 1;

        double result = Calculation.calculateValueOfExpression_6(a,b,x);
        assertEquals(1.0088,result, 0.0001);
    }

    @Test
    public void testBigDecimalExpression(){
        BigDecimal a = new BigDecimal("0.3");
        BigDecimal b = new BigDecimal("0.4");

        BigDecimal expected = new BigDecimal("0.28");

        BigDecimal result = Calculation.bigDecimalExpression(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testBigDecimalCalculateAndCompare(){
        BigDecimal a = new BigDecimal("0.3");
        BigDecimal b = new BigDecimal("0.4");
        BigDecimal value = new BigDecimal("0.0063");

        assertTrue(Calculation.calculateAndEqual(a,b,value));
    }

    @Test
    public void testBigDecimalCalculationAndRounding(){
        BigDecimal a = new BigDecimal("0.3");
        BigDecimal b = new BigDecimal("0.4");

        BigDecimal expected = new BigDecimal("0.557");
        assertEquals(expected ,Calculation.calculateAndRound(a,b));
    }
}
