package com.mathodcoast;

import java.util.Arrays;
import java.util.Objects;

/**
 *  {@link ArrayLongWrapperImpl} is an implementation of {@link ArrayLongWrapper} interface. It is a data structure based
 *  on array. *
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

    public static ArrayLongWrapper of(long... elements) {
        ArrayLongWrapper arrayLongWrapper = new ArrayLongWrapperImpl(elements.length);
        for(long element: elements){
            arrayLongWrapper.add(element);
        }
        return arrayLongWrapper;
    }

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

    @Override
    public void add(int index,long element) {
        increaseDataArrayIfFull();
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        dataArray[index] = element;
        size++;
    }

    @Override
    public long get(int index) {
        Objects.checkIndex(index,size);
        return dataArray[index];
    }

    @Override
    public void set(int index,long element) {
        Objects.checkIndex(index,size);
        dataArray[index] = element;
    }

    @Override
    public void remove(int index) {
        if (index == size - 1){
            dataArray = getTrimmedArrayToSize(size - 1);
        }else {
            System.arraycopy(dataArray,index + 1,dataArray,index,size - index - 1);
        }
        size--;
    }

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

    @Override
    public long[] toArray() {
        return getTrimmedArrayToSize(size);
    }

    private long[] getTrimmedArrayToSize(int size) {
        return Arrays.copyOf(dataArray,size);
    }

    @Override
    public String toString() {
     return  Arrays.toString(getTrimmedArrayToSize(size));
    }

    @Override
    public int size() {
        return size;
    }
}
