package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class RecursionMethodsTest {

    @Test
    public void testFactorialRecursion(){
        int arg = 6;

        int result = RecursionMethods.factorial(arg);

        assertEquals(720,result);
    }

    @Test
    public void testFibonacciSumRecursion(){
        int arg = 10;

        int result = RecursionMethods.fibonacciSum(arg);

        assertEquals(55,result);
    }
}
