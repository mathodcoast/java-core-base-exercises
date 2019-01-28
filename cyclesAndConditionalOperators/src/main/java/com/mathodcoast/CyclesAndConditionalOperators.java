package com.mathodcoast;


public class CyclesAndConditionalOperators {

    /**
     * This  method returns the sum of all third numbers from zero to range value.
     *
     * @param range is the last value of sequenced integer numbers range
     */
    public static int sumOfThirdNumbers(int range) {
        int sum = 0;
        for (int i = 0; i < range; ) {
            sum += i;
            i += 3;
        }
        return sum;
    }

    /**
     * The method decrease number on change number if it bigger than condition number and increase it on change number otherwise.
     *
     * @param number          number
     * @param conditionNumber number for comparison
     * @param changeNumber    number for changing
     */
    public static int simpleNumberCondition(int number,int conditionNumber,int changeNumber) {
        return number > conditionNumber ? number - changeNumber : number + changeNumber;
    }


    /**
     * Three conditions are given for the number.
     * 1. If the number is from 2 to 5 inclusive, the method increase the number on 'addNumber'
     * 2. If the number is from 7 to 40, the method reduce it on 'reduceNumber'
     * 3. If the number is less then 0 or bigger then 3000, the method multiple it on 'multipleNumber'
     *
     * @param number         main number
     * @param addNumber      number for adding
     * @param reduceNumber   number for reducing
     * @param multiplyNumber number for multiplying
     */
    public static int numberConditions(int number,int addNumber,int reduceNumber,int multiplyNumber) {
        int result = 0;
        if (number >= 2 & number <= 5) {
            result = number + addNumber;
        } else {
            if (number > 7 & number < 40) {
                result = number - reduceNumber;
            } else {
                if (number > 3000 | number < 0) {
                    result = number * multiplyNumber;
                }
            }
        }
        return result;
    }

    /**
     * This method returns a season string where
     *
     * @param month is a number of month
     *              If month number is wrong the method returns "It isn't a month number"
     */
    public static String monthsAndSeasons(int month) {
        switch (month) {
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Autumn";
            case 12:
            case 1:
            case 2:
                return "Winter";
        }
        return "It isn't a month number";
    }

    /**
     * This method checks if the three vertexes belong to rectangle and than finds fourth vertex coordinates.
     * Also the method checks if vertexes coordinates arrays length is 2. If all checks failed the method returns
     * empty coordinate vertex array.
     * The vertexes named by clock arrow from a lower left vertex
     *
     * @param a are coordinates of 'A' vertex
     * @param b are coordinates of 'B' vertex
     * @param c are coordinates of 'C' vertex
     * @return a coordinates od fourth vertex
     */
    public static int[] findForthVertexOfRectangle(int[] a,int[] b,int[] c) {
        if (a.length == 2 & b.length == 2 & c.length == 2) {
            if (a[0] == b[0] & b[1] == c[1]) {
                int[] d = new int[2];
                d[0] = c[0];
                d[1] = a[1];
                return d;
            }
        }
        return new int[0];
    }

    /**
     * This method checks if the three vertexes belong to rectangle and than finds fourth vertex coordinates.
     * Also the method checks if vertexes coordinates arrays length is 2. If all checks failed the method returns
     * empty coordinate vertex array.
     * The vertexes names don't link to specific vertexes on rectangle.
     */
    public static int[] findForthVertexOfRectangleAdvanced(int[] v1,int[] v2,int[] v3) {

        if (v1.length == 2 & v2.length == 2 & v3.length == 2) {
            int[] v4 = new int[2];
            if (v1[0] == v2[0]) {
               return findSecondCoordinate(v1,v2,v3,v4);
            } else {
                if (v1[0] == v3[0]){
                  return  findSecondCoordinate(v1,v3,v2,v4);
                } else {
                    if (v2[0] == v3[0]){
                       return findSecondCoordinate(v2,v3,v1,v4);
                    }
                }
            }
        }
        return new int[0];
    }

    private static int[] findSecondCoordinate(int[] v1,int[] v2,int[] v3,int[] v4) {
        v4[0] = v3[0];
        if (v2[1] == v3[1]) {
            v4[1] = v1[1];
            return v4;
        } else {
            if(v1[1] == v3[1]){
                v4[1] = v2[1];
                return v4;
            }
        }
        return new int[0];
    }


}
