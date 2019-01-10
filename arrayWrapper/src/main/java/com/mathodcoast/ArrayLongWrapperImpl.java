package com.mathodcoast;

import java.util.Arrays;
import java.util.Objects;

/**
 *  {@link ArrayLongWrapperImpl} is an implementation of {@link ArrayLongWrapper} interface. It is a data structure based
 *  on array.
* */
public class ArrayLongWrapperImpl implements ArrayLongWrapper {

    private long[] dataArray;
    private int size;

    public ArrayLongWrapperImpl(int buffer) {
        dataArray = new long[buffer];
    }

    public ArrayLongWrapperImpl() {
        dataArray = new long[5];
    }

    /**
     * Creates and returns an instance of {@link ArrayLongWrapperImpl} with provided
     * @param elements
     * @return new instance
    * */
    public static ArrayLongWrapper of(long... elements) {
        ArrayLongWrapper arrayLongWrapper = new ArrayLongWrapperImpl(elements.length);
        for(long element: elements){
            arrayLongWrapper.add(element);
        }
        return arrayLongWrapper;
    }

    /**
     * Adds an element to the array and returns index of position.
     * @param element element to add
     * @return index of element
    * */
    @Override
    public int add(long element) {
        increaseDataArrayIfFull();
        dataArray[size] = element;
        return size++;
    }

    private void increaseDataArrayIfFull() {
        if (dataArray.length <= size) {
            dataArray = getTrimmedArrayToSize(dataArray.length*2);
        }
    }

    /**
     *  Adds an element to the specific position in the array where
     * @param index index of position
     * @param element element to add
    * */
    @Override
    public void add(int index,long element) {
        increaseDataArrayIfFull();
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        dataArray[index] = element;
        size++;
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
    * */
    @Override
    public long get(int index) {
        Objects.checkIndex(index,size);
        return dataArray[index];
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index position of value
     * @param element a new value
    * */
    @Override
    public void set(int index,long element) {
        Objects.checkIndex(index,size);
        dataArray[index] = element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if (index == size - 1){
            dataArray = getTrimmedArrayToSize(size - 1);
        }else {
            System.arraycopy(dataArray,index + 1,dataArray,index,size - index - 1);
        }
        size--;
    }

    /**
     * Finds an index of the element.
     *
     * @param element is element
     * @return If element exist method returns its first position index, otherwise it returns -1
    * */
    @Override
    public int find(long element) {
        int i = 0;
        int index = -1;
        while(i < size){
            if (dataArray[i] == element) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    /**
     * This method unwraps the wrapper of array.
     *
     * @return an array
    * */
    @Override
    public long[] toArray() {
        return getTrimmedArrayToSize(size);
    }

    private long[] getTrimmedArrayToSize(int size) {
        return Arrays.copyOf(dataArray,size);
    }

    /**
     * @return A String implementation of wrapper
    * */
    @Override
    public String toString() {
     return  Arrays.toString(getTrimmedArrayToSize(size));
    }

    /**
     * @return amount of saved values
    * */
    @Override
    public int size() {
        return size;
    }
}
