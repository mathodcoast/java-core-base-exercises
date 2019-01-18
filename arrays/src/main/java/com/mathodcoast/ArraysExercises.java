package com.mathodcoast;


import java.util.Arrays;

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

    /** #3
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

    /** #4
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

    /** #5
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

    /**
     * This method returns a count of matches of number
     * @param number
     * in array:
     * @param array
     *
    * */
    public static int getCountOfMatches(int[] array, int number){
        int result = 0;
        for (int element :
                array) {
            if (element == number) result++;
        }
        return result;
    }

    /** #6
     * This method returns two-dimensional array. All the array must be filled with ordered ascending numbers starts from 1.
     *
    * */
    public static int[][] createTwoDimensionalArray(int high, int width){
        int[][] array = new int[high][width];
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ++num;
            }
        }
        return array;
    }

    /**
     * This method creates a new smaller array from provided, removing numbers along the perimeter.
     *
     * @param squareArray provided array
    */
    public static int[][] getArrayWithDecreasedPerimeter(int[][] squareArray){

        int[][] newArray = new int[squareArray.length - 2][squareArray.length - 2];

        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray[i].length; j++) {
                if (i != 0 & i != squareArray.length - 1 & j != 0 & j != squareArray[i].length - 1){
                    newArray[i-1][j-1] = squareArray[i][j];
                }
            }
        }
         return newArray;
    }
    /**
     * This method creates and returns a two-dimensional array which filled in triangle form by ones. The triangle is located from
     * the diagonal inclusive to the left lower corner.
     *
     * @param faceSize size of square
    */
    public static int[][] getTriangleFromSquareArray(int faceSize){
        int[][] array = new int[faceSize][faceSize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
               array[i][j] = 1;
            }
        }
        return array;
    }

    /**
     * This method get a two-dimensional array:
     * @param matrix
     * You should to find a number which locate in all rows of array.
     *
     * @return number
    * */
    public static int getNumberWhichLocateInAllRows(int[][] matrix) {
        int result = 0;

        int[] matches = new int[matrix.length];
        for (int challenger = 0; challenger < matrix.length; challenger++) {
            for (int row = 1; row < matrix.length; row++) {
                int rowMatches = 0;
                for (int column = 0; column < matrix[row].length; column++) {
                    if (matrix[0][challenger] == matrix[row][column]) {
                        if (rowMatches == 0) {
                            matches[challenger] = matches[challenger] + 1;
                            rowMatches++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matches.length; i++) {
            if (matches[i] == matrix.length - 1){
                result = matrix[0][i];
            }
        }
        return result;
    }
}
