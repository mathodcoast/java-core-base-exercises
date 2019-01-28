package com.bobocode;

import com.mathodcoast.CyclesAndConditionalOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//70 77 78 105 104 110 134
@RunWith( JUnit4.class )
public class CyclesAndConditionalOperatorsTest {

    @Test
    public void testSumOfThirdNumbers(){
        int range = 10;

        int result = CyclesAndConditionalOperators.sumOfThirdNumbers(range);
        assertEquals(18,result);
    }

    @Test
    public void testSimpleNumberCondition(){
        int number = 5;
        int addNumber = 10;
        int conditionNumber = 4;

        int result = CyclesAndConditionalOperators.simpleNumberCondition(number, conditionNumber, addNumber);

        assertEquals(-5, result);
    }

    @Test
    public void testNumberConditions(){
        int numberA = 50;
        int numberB = 5;
        int numberC = 20;
        int numberD = -10;
        int addNumber = 10;
        int reduceNumber = 100;
        int multiplyNumber = 3;

        int resultA = CyclesAndConditionalOperators.numberConditions(numberA, addNumber, reduceNumber, multiplyNumber);
        int resultB = CyclesAndConditionalOperators.numberConditions(numberB, addNumber, reduceNumber, multiplyNumber);
        int resultC = CyclesAndConditionalOperators.numberConditions(numberC, addNumber, reduceNumber, multiplyNumber);
        int resultD = CyclesAndConditionalOperators.numberConditions(numberD, addNumber, reduceNumber, multiplyNumber);

        assertEquals(0, resultA);
        assertEquals(15, resultB);
        assertEquals(-80, resultC);
        assertEquals(-30, resultD);
    }

    @Test
    public void testMonthsAndSeasons(){
        int monthA = 3;
        int monthB = 6;
        int monthC = 9;
        int monthD = 1;

        String resultA = CyclesAndConditionalOperators.monthsAndSeasons(monthA);
        String resultB = CyclesAndConditionalOperators.monthsAndSeasons(monthB);
        String resultC = CyclesAndConditionalOperators.monthsAndSeasons(monthC);
        String resultD = CyclesAndConditionalOperators.monthsAndSeasons(monthD);

        assertEquals("Spring", resultA);
        assertEquals("Summer", resultB);
        assertEquals("Autumn", resultC);
        assertEquals("Winter", resultD);
    }

    @Test
    public void testFindForthVertexOfRectangle(){
        int[] a = {2,2};
        int[] b = {2,6};
        int[] c = {7,6};

        int[] wrongA = {1,2};
        int[] wrongB = {2,2,3};

        int[] result = CyclesAndConditionalOperators.findForthVertexOfRectangle(a,b,c);
        int[] wrongResultA = CyclesAndConditionalOperators.findForthVertexOfRectangle(wrongA,b,c);
        int[] wrongResultB = CyclesAndConditionalOperators.findForthVertexOfRectangle(wrongB,b,c);
        int[] expected = {7,2};
        int[] wrongExpected = new int[0];
        assertEquals(Arrays.toString(expected),Arrays.toString(result));
        assertEquals(Arrays.toString(wrongExpected),Arrays.toString(wrongResultA));
        assertEquals(Arrays.toString(wrongExpected),Arrays.toString(wrongResultB));
    }

    @Test
    public void testFindForthVertexOfRectangleAdvanced(){
        int[] a = {2,2};
        int[] b = {2,6};
        int[] c = {7,6};

        int[] resultA = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(a,b,c);
        int[] resultB = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(a,c,b);
        int[] resultC = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(c,b,a);
        int[] resultD = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(b,c,a);
        int[] resultE = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(b,a,c);
        int[] resultF = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(c,a,b);

        int[] expected = {7,2};

        assertEquals(Arrays.toString(expected),Arrays.toString(resultA));
        assertEquals(Arrays.toString(expected),Arrays.toString(resultB));
        assertEquals(Arrays.toString(expected),Arrays.toString(resultC));
        assertEquals(Arrays.toString(expected),Arrays.toString(resultD));
        assertEquals(Arrays.toString(expected),Arrays.toString(resultE));
        assertEquals(Arrays.toString(expected),Arrays.toString(resultF));

    }

    @Test
    public void testFindForthVertexOfRectangleAdvancedIncorrect(){
        int[] wrongA = {1,2};
        int[] wrongB = {2,2,3};

        int[] b = {2,6};
        int[] c = {7,6};

        int[] wrongResultA = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(wrongA,b,c);
        int[] wrongResultB = CyclesAndConditionalOperators.findForthVertexOfRectangleAdvanced(wrongB,b,c);

        int[] wrongExpected = new int[0];

        assertEquals(Arrays.toString(wrongExpected),Arrays.toString(wrongResultA));
        assertEquals(Arrays.toString(wrongExpected),Arrays.toString(wrongResultB));
    }
}
