package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith( JUnit4.class )
public class ArraysExercisesTest {

    @Test
    public void testArraysExercise_1(){
        byte[] byteArray = new byte[10];

        byte[] expectArray = {1,0,0,0,0,0,0,0,0,1};
        byte[] result = ArraysExercises.setArrayWithZerosAndOneOnBothSides(byteArray);

        assertEquals(Arrays.toString(expectArray),Arrays.toString(result));
    }

    @Test
    public void testArraysExercise_2(){
        byte[] byteArray = new byte[10];
        byte[] expectArray = {0,1,0,1,0,1,0,1,0,1};

        byte[] result = ArraysExercises.setArrayWithZerosAndOneInTurn(byteArray);

        assertEquals(Arrays.toString(expectArray),Arrays.toString(result));
    }

    @Test
    public void testArraysExercise_3(){
        int[] intArray = new int[10];
        int[] expectArray = {1,3,5,7,9,11,13,15,17,19};

        int[] result = ArraysExercises.setArrayWithNotEvenNumbers(intArray);

        assertEquals(Arrays.toString(expectArray),Arrays.toString(result));
    }

    @Test
    public void testArraysExercise_4(){
        int length = 10;
        int x = 2;
        int d = 3;
        int[] expectArray = {2,5,8,11,14,17,20,23,26,29};

        int[] result = ArraysExercises.setArrayWithArithmeticalProgression(length,x,d);

        assertEquals(Arrays.toString(expectArray),Arrays.toString(result));
    }

    @Test
    public void testArraysExercise_5(){
        int length = 11;

        int[] expectArray = {0,1,1,2,3,5,8,13,21,34,55};

        int[] result = ArraysExercises.getArrayWithFibonacciNumbers(length);

        assertEquals(Arrays.toString(expectArray),Arrays.toString(result));
    }

    @Test
    public void testArraysExercise_6() {
        int[] array  = {5,8,6,7,12,3,6,5,4,89,4,5,21,6,72,3,8};

        assertEquals(3, ArraysExercises.getCountOfMatches(array,5));
    }

    @Test
    public void testArraysExercise_7(){
        int width = 3;
        int high = 4;

        int[][] expectArray = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        int[][] result = ArraysExercises.createTwoDimensionalArray(4,3);
        System.out.println("Test #6 expected: " + Arrays.deepToString(expectArray));
        System.out.println("Test #6 result:   " + Arrays.deepToString(result));
        assertTrue(Arrays.deepEquals(expectArray,result));
    }

    @Test
    public void testArraysExercise_8(){
        int[][] squareArray = new int[][]{{1,2,3,4},{5,6,7,8},{9,11,12,13},{14,15,16,17}};
        int[][] expectedArray = new int[][]{{6,7},{11,12}};
        int[][] result = ArraysExercises.getArrayWithDecreasedPerimeter(squareArray);

        printArray(squareArray,"Test #7 passed:");

        printArray(expectedArray,"Test #7 expected:");

        printArray(result,"Test #7 result:");
        assertTrue(Arrays.deepEquals(expectedArray,result));
    }

    private void printArray(int[][] squareArray,String massage) {
        System.out.println();
        System.out.println(massage);
        for (int i = 0; i < squareArray.length; i++) {
            System.out.println(Arrays.toString(squareArray[i]));
        }
    }

    @Test
    public void testArraysExercise_9(){
        int faceSize = 5;

        int[][] expectedArray = new int[][]{{1,0,0,0,0},{1,1,0,0,0},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,1,1}};
        int[][] result = ArraysExercises.getTriangleFromSquareArray(faceSize);

        printArray(expectedArray,"Test #8 expected:");
        printArray(result,"Test #8 result:");
        assertTrue(Arrays.deepEquals(expectedArray,result));
    }

    @Test
    public void testArraysExercise_10(){
        int[][] matrix = new int[][]{{1,5,9,3,4},
                                     {1,4,5,7,4},
                                     {9,1,8,5,4},
                                     {2,5,9,8,3},
                                     {5,1,7,1,4}};
        int result = ArraysExercises.getNumberWhichLocateInAllRows(matrix);
        assertEquals(5,result);
    }
}
