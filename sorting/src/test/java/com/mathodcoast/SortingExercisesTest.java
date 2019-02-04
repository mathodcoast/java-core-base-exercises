package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class SortingExercisesTest {

    @Test
    public void testSwap(){
        int[] data = {1,2,3,6,5,6};
        int[] expected = {6,2,3,6,5,1};

        SortingExercises.swap(data,0,5);
        assertEquals(Arrays.toString(expected),Arrays.toString(data));
    }

    @Test
    public void testMergeSortedHalves(){
        int[] data = {190,0,2,4,6,8,10,11,13,1,3,5,7,9,12,14,201,256};
        int[] expectData = {190,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,201,256};
        int[] workSpace = new int[data.length];
        int loweBound = 1;
        int upperBound = 15;
        int middle = (upperBound + loweBound) / 2;

        SortingExercises.mergeSortedHalves(data, workSpace, loweBound, middle, upperBound);
        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
    }

    @Test
    public void testMedianOf3Algorithm(){
        int[] data = {5 ,6,12,4,8,9 ,10,1,7,2,11,3 };
        int[] expectedData = {3,6,12,4,8,11,10,1,7,2,5,9};
        int median = SortingExercises.medianOf3(data,0, data.length - 1);

        assertEquals(Arrays.toString(expectedData),Arrays.toString(data));
        assertEquals(5,median);
    }

    @Test
    public void testPartitionAlgorithm(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectedData = {3,2,1,4,5,11,10,12,7,6,8,9};
        int median = SortingExercises.medianOf3(data, 0, data.length - 1);
        SortingExercises.partitionIt(data, 0, data.length - 1, median);

        assertEquals(Arrays.toString(expectedData),Arrays.toString(data));
    }

    @Test
    public void testBubbleSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectedData = {1,2,3,4,5,6,7,8,9,10,11,12};
        int comparision = SortingExercises.bubbleSorting(data);

        assertEquals(Arrays.toString(expectedData),Arrays.toString(data));
        assertEquals(95,comparision);

    }

    @Test
    public void testSelectionSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12};
        int comparision = SortingExercises.selectionSorting(data);

        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
        assertEquals(77,comparision);
    }

    @Test
    public void testPasteSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12};
        int comparision = SortingExercises.insertionSorting(data, 0, data.length - 1);

        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
        assertEquals(58,comparision);
    }

    @Test
    public void testMergeSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9,14,13};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int operations = SortingExercises.mergeSorting(data);

        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
       // assertEquals(58,operations);
    }

    @Test
    public void testShellsSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12};
        int comparision = SortingExercises.shellSorting(data);

        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
        assertEquals(51,comparision);
    }

    @Test
    public void testQuickSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9,14,13};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        SortingExercises.quickSorting(data);

        assertEquals(Arrays.toString(expectData),Arrays.toString(data));
    }
}
