package com.mathodcoast;

import java.util.Arrays;

public class SortingExercises {

    public static void swap(int[] data,int indexA, int indexB) {
        int temp = data[indexB];
        data[indexB] = data[indexA];
        data[indexA] = temp;
    }

    public static void mergeSortedHalves(int[] dataArray,int[] workSpace, int lowerBound, int middle, int upperBound){
        System.out.println("--------------------------");
        System.out.println("LowerBound: " + lowerBound + " | Middle: " + middle + " | UpperBound: " + upperBound);
        int j = lowerBound;
        int rightPointer = middle + 1;
        int leftPointer = lowerBound;
        //int range = upperBound - lowerBound;
        while (leftPointer <= middle && rightPointer <= upperBound){
            if (dataArray[leftPointer] < dataArray[rightPointer]){
                workSpace[j++] = dataArray[leftPointer++];
            } else{
                workSpace[j++] = dataArray[rightPointer++];
            }
        }
        while (leftPointer <= middle){
            workSpace[j++] = dataArray[leftPointer++];
        }
        while (rightPointer <= upperBound){
            workSpace[j++] = dataArray[rightPointer++];
        }
        System.out.println("data:        " + Arrays.toString(dataArray));
        System.out.println("workspace:   " + Arrays.toString(workSpace));
        for (int i = lowerBound; i <= upperBound; i++) {
            dataArray[i] = workSpace[i];
        }
    }

    /**
     * This method sorts array's data by bubble sorting and returns optimal amount of operations over numbers.
     * The amount of operations is a sum of all possible comparisons, copies and swaps of numbers.
     */
    public static int bubbleSorting(int[] data) {
        int comparison = 0;
        int swaps = 0;
        int notSorted = data.length;
        for (int out = 0; out < data.length; out++) {
            for (int in = 1; in < notSorted; in++) {
                if (data[in - 1] > data[in]){
                    swap(data,in, in - 1);
                    swaps++;
                }
                comparison++;
            }
           notSorted--;
        }
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparison: " + comparison);
        return swaps + comparison;
    }

    /**
     * This method sorts array's data by selection sorting and returns optimal amount of operations over numbers.
     * The amount of operations is a sum of all possible comparisons, copies and swaps of numbers.
     */

    public static int selectionSorting(int[] data) {
        int minNotSorting;
        int comparison = 0;
        int swaps = 0;
        for (int out = 0; out < data.length - 1; out++) {
            minNotSorting = out;
            for (int in = out + 1; in < data.length; in++) {

                if (data[minNotSorting] > data[in]){
                    minNotSorting = in;
                }
                comparison++;
            }
            swap(data,out,minNotSorting);
            swaps++;
        }
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparison: " + comparison);
        return swaps + comparison;
    }

    /**
     * This method sorts array's data by insertion sorting and returns optimal amount of operations over numbers.
     * The amount of operations is a sum of all possible comparisons, copies and swaps of numbers.
     */

    public static int insertionSorting(int[] data, int left, int right) {
        int comparison = 0;
        int swaps = 0;

        for (int out = left + 1; out <= right; out++) {
            int temp = data[out];
            int in = out;
            while (in > left && temp <= data[in - 1]){
                data[in] = data[in - 1];
                comparison++;
                swaps++;
                in--;
            }
            data[in] = temp;
        }
        System.out.println("Swaps: " + swaps);
        System.out.println("Comparison: " + comparison);
        return swaps + comparison;
    }

    /**
     * This method sorts array's data by Shell's sorting method and returns optimal amount of operations over numbers
     * where interval expression is 'interval = interval * 3 + 1'.
     * The amount of operations is a sum of all possible comparisons, copies and swaps of numbers.
     */

    public static int shellSorting(int[] data) {
        int inner,outer;
        int operations = 0;
        int temp;
        int interval = 1;
        while (interval <= data.length){
         interval = interval * 3 + 1;
         operations++;
        }

        while(interval > 0){
            System.out.println("Range: " + interval);
            for (outer = interval; outer < data.length; outer++) {
                temp = data[outer];
                inner = outer;

                while(inner > interval - 1 && data[inner - interval] >= temp ){
                    data[inner] = data[inner - interval];
                    System.out.println("Inner: " + inner);
                    inner -= interval;
                    operations++;
                }
                data[inner] = temp;
                System.out.println(Arrays.toString(data));
                operations++;
            }
            interval = (interval - 1) / 3;
            operations++;
        }

        return operations;
    }

    public static int mergeSorting(int[] dataArray) {
        int[] workspace = new int[dataArray.length];
        recMergeSorting(dataArray,workspace,0,dataArray.length - 1);
        return 0;
    }

    private static void recMergeSorting(int[] dataArray,int[] workSpace,int lowerBound,int upperBound){
        if (lowerBound == upperBound){
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSorting(dataArray,workSpace,lowerBound,mid);
            recMergeSorting(dataArray,workSpace,mid + 1, upperBound);
            mergeSortedHalves(dataArray,workSpace,lowerBound,mid,upperBound);
            System.out.println("After merge: " + Arrays.toString(dataArray));
        }
    }

    public static int partitionIt(int[] data, int left, int right, int pivot) {
        int leftPointer = left;
        int rightPointer = right - 1;
        while(true){
            while (data[++leftPointer] < pivot);
            while (data[--rightPointer] > pivot);
            if (leftPointer >= rightPointer){
                break;
            } else {
                swap(data,leftPointer, rightPointer);
            }
        }
        swap(data, leftPointer, right - 1);
        return leftPointer;
    }

    public static int medianOf3(int[] data,int left,int right){
        int center = (left + right) / 2;
        System.out.println("Left: " + left + " | Center: " + center + " | Right: " + right);
        System.out.println(Arrays.toString(data));

        if(data[left] > data[center]){
            swap(data, left, center);
        }
        if (data[left] > data[right]){
            swap(data, left, right);
        }
        if(data[center] > data[right]){
            swap(data,center,right);
        }
        swap(data,center,right-1);

        System.out.println(Arrays.toString(data));
        System.out.println();
        return  data[right - 1];
    }

    public static void quickSorting(int[] data) {
        recQuickSorting(data,0,data.length - 1);
    }

    private static void recQuickSorting(int[] data,int left,int right) {
        int size = right - left + 1;
        System.out.println("size: " + size);
        if(size < 4){
            insertionSorting(data,left,right);
            //swap(data,left + 1, right - 1);
        } else {
            int median = medianOf3(data,left,right);
            int partition = partitionIt(data,left,right,median);

            System.out.println("median: " + median);
            System.out.println(Arrays.toString(data));
            System.out.println();

            recQuickSorting(data,left,partition -1);
            recQuickSorting(data,partition + 1, right);
        }

    }
}
