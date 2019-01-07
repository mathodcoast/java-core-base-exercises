package com.mathodcoast;


public class ArraysExercises {

    /** #1
     * This method sets zeros to all array except first and last index where sets one.
     *
     * @return configured array
    * */
    public static byte[] setArrayWithZerosAndOneOnBothSides(byte[] byteArray) {
        for (int i = 1; i < byteArray.length - 1; i++) {
            byteArray[i] = 0;
        }
        byteArray[0] = 1;
        byteArray[byteArray.length - 1] = 1;

        return byteArray;
    }

    /** #2
     * This method sets zeros and one in turn to all array. Starts wit zero.
     *
     * @return configured array
     * */
    public static byte[] setArrayWithZerosAndOneInTurn(byte[] byteArray) {

        for(int i = 0; i < byteArray.length;){
            byteArray[i] = 0;
            i++;
            byteArray[i] = 1;
            i++;
        }
        return byteArray;
    }

    /**
     * This method returns an array with consecutive and not even numbers.
    * */
    public static int[] setArrayWithNotEvenNumbers(int[] byteArray) {
        int j = 1;
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = j;
            j = j + 2;
        }
        return byteArray;
    }

    /**
     * This method returns an array with arithmetical progression where
     *
     * @param length is a length of array
     * @param x is a first element
     * @param d is a difference
    * */
    public static int[] setArrayWithArithmeticalProgression(int length,int x,int d) {
        int[] intArray = new int[length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = x;
            x = x + d;
        }
        return  intArray;
    }

    /**
     * This method returns an array with fibonacci numbers
     *
     * @param length is length of array
    * */
    public static int[] getArrayWithFibonacciNumbers(int length) {
        int[] intArray = new int[length];
        intArray[0] = 0;
        int fibo = 1;
        for (int i = 1; i < intArray.length; i++) {
            intArray[i] = intArray[i - 1] + fibo;
            fibo = intArray[i - 1];
        }
        return intArray;
    }
}
