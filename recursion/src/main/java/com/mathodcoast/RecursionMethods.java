package com.mathodcoast;

import java.util.List;

public class RecursionMethods {

    /**
     * This method calculates a factorial of argument by recursion.
     */
    public static int factorial(int arg) {
        if (arg == 1) {
            return 1;
        } else {
            return arg * factorial(arg - 1);
        }
    }
    /**
    * This method calculates a fibonacci number where
     * @param value is value in fibonacci sequence.
    * */
    public static int fibonacciSum(int value) {
        if (value == 0) {
            return 1;
        } else {
            if (value == 1) {
                return 1;
            } else {
                return value + fibonacciSum(value - 1);
            }
        }
    }

    /**
     * This method finds all variations of numbers of
     * @param array and save them in
     * @param varArrays list
    * */
    public static void variations(List<int[]> varArrays,int[] array,int size) {
        if (size < 2) {
            varArrays.add(array.clone()); // Why does it need to clone?
        } else {
            for (int k = 0; k < size; k++) {
                if(k < 2) {
                    swap(array,k,k + 1);
                }
                variations(varArrays,array,size - 1);
            }
        }
    }

    /**
     *  This method swaps two elements of
     * @param arr array where
     * @param index0 is index of first element
     * @param index1 is index of second element
     *  This method is helper and doesn't have a recursion of itself.
    * */
    public static void swap(int[] arr,int index0,int index1) {
        int temp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = temp;
    }
}
