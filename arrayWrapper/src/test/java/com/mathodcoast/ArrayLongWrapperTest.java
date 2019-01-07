package com.mathodcoast;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class ArrayLongWrapperTest {

    private ArrayLongWrapper arrayLongWrapper = new ArrayLongWrapperImpl();

    @Test
    public void testAddElementIntoEmptyArray(){

        int index = arrayLongWrapper.add(10);

        long getA = arrayLongWrapper.get(0);

        assertEquals(10,getA);
        assertEquals(0,index);
    }

    @Test
    public void testAddElements(){
        ArrayLongWrapper arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78);

        int size = arrayLongWrapper.size();

        assertEquals(15,arrayLongWrapper.get(0));
        assertEquals(69,arrayLongWrapper.get(1));
        assertEquals(58,arrayLongWrapper.get(2));
        assertEquals(78,arrayLongWrapper.get(3));

        assertEquals(4,size);
    }

    @Test
    public void testAddElementToFullArray(){
        ArrayLongWrapper arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,68);
        arrayLongWrapper.add(89);

        int size = arrayLongWrapper.size();

        assertEquals(89, arrayLongWrapper.get(5));
        assertEquals(6,size);
    }

    @Test
    public void testAddElementByIndex(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,68);

        arrayLongWrapper.add(50);
        arrayLongWrapper.add(2,10);
        int size = arrayLongWrapper.size();

        assertEquals(10, arrayLongWrapper.get(2));
        assertEquals(68, arrayLongWrapper.get(5));
        assertEquals(7,size);
    }

    @Test
    public void testGetElementsByIndex(){
        arrayLongWrapper.add(10);
        arrayLongWrapper.add(15);
        arrayLongWrapper.add(20);

        long getA = arrayLongWrapper.get(0);
        long getB = arrayLongWrapper.get(1);
        long getC = arrayLongWrapper.get(2);

        int size = arrayLongWrapper.size();

        assertEquals(10,getA);
        assertEquals(15,getB);
        assertEquals(20,getC);

        assertEquals(3,size);
    }

    @Test( expected =  IndexOutOfBoundsException.class)
    public void testGetFirstElementFromEmptyArray(){
        arrayLongWrapper.get(0);
    }

    @Test( expected =  IndexOutOfBoundsException.class)
    public void testGetElementByNegativeIndex(){
        arrayLongWrapper.get(-1);
    }

    @Test( expected =  IndexOutOfBoundsException.class)
    public void testGetElementByIndexEqualsToArraySize(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78);
        arrayLongWrapper.get(4);
    }

    @Test
    public void testSetElementByIndex(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78);

        arrayLongWrapper.set(2,10);

        assertEquals(10,arrayLongWrapper.get(2));
        assertEquals(78,arrayLongWrapper.get(3));
        assertEquals(4,arrayLongWrapper.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetElementByIndexEqualToSize(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78);

        arrayLongWrapper.set(4,10);
    }

    @Test
    public void testRemoveElementByIndex(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);

        arrayLongWrapper.remove(2);

        assertEquals(78,arrayLongWrapper.get(2));
        assertEquals(69,arrayLongWrapper.get(1));
        assertEquals(4,arrayLongWrapper.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElementByIndexEqualToSize(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78);

        arrayLongWrapper.remove(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastElementByIndex(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);

        arrayLongWrapper.remove(4);

        assertEquals(78,arrayLongWrapper.get(3));
        assertEquals(4,arrayLongWrapper.size());
        arrayLongWrapper.get(4);

        System.out.println(arrayLongWrapper.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElementByIndexOutOfBounds(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);

        arrayLongWrapper.remove(6);
    }

    @Test
    public void testFindIndexOfElement(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);

        int index = arrayLongWrapper.find(58);
        assertEquals(2,index);
    }

    @Test
    public void testFindNotExistingElement(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);

        int index = arrayLongWrapper.find(60);
        assertEquals(-1,index);
    }

    @Test
    public void testToArray(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);
        arrayLongWrapper.add(265);

        long[] result = arrayLongWrapper.toArray();
        long[] expected = {15,69,58,78,100,265};

        assertEquals(Arrays.toString(expected),Arrays.toString(result));
    }

    @Test
    public void testToString(){
        arrayLongWrapper = ArrayLongWrapperImpl.of(15,69,58,78,100);
        arrayLongWrapper.add(265);

        String result = arrayLongWrapper.toString();
        long[] expected = {15,69,58,78,100,265};

        assertEquals(Arrays.toString(expected),result);
    }

    @Test
    public void testSize(){
        arrayLongWrapper.add(10);
        arrayLongWrapper.add(15);
        arrayLongWrapper.add(20);

        int size = arrayLongWrapper.size();

        assertEquals(3,size);
    }

    @Test
    public void testSizeOfEmptyArrayWrapper(){
        assertEquals(0,arrayLongWrapper.size());
    }
}
