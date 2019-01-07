package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class SortingExercisesTest {

    @Test
    public void testIncreaseValuesWithLeftToRightBubbleSorting(){
        int[] data = {3,6,12,4,8,5,10,1,7,2,11,9};
        int[] expectData = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] result = SortingExercises.increaseValuesWithLeftToRightBubbleSorting(data);

        assertEquals(expectData,result);
    }
}
