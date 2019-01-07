package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
}
