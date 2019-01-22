package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;

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

    @Test
    public void testVariations(){
        int[] arr = {1,2,3};

        List<int[]> varArray = new ArrayList<>();

        int[][] expected = {{1,2,3},{2,1,3},{3,1,2},{3,2,1},{1,3,2},{2,3,1}};

        RecursionMethods.variations(varArray,arr,arr.length);

        System.out.println("Result");
        for (int[] array : varArray) {
            System.out.println(Arrays.toString(array));
        }
        printArray(expected, "Expected");

        assertThat(varArray, hasItems(expected[0],expected[1],expected[2],expected[3],expected[4],expected[5]));
    }

    @Test
    public  void testSwap(){
        int[] arr = {3,4,5};

        RecursionMethods.swap(arr, 0, 2);
        assertEquals(5,arr[0]);
        assertEquals(3, arr[2]);
    }

    private void printArray(int[][] squareArray,String massage) {
        System.out.println();
        System.out.println(massage);
        for (int i = 0; i < squareArray.length; i++) {
            System.out.println(Arrays.toString(squareArray[i]));
        }
    }
}
