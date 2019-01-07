package com.mathodcoast;

public class RecursionMethods {

    /**
     * This method calculates factorial of argument by recursion.
     */
    public static int factorial(int arg) {
        if (arg == 1) {
            return 1;
        } else {
            return arg * factorial(arg - 1);
        }
    }

    public static int fibonacciSum(int arg) {
        if (arg == 0) {
            return 1;
        } else {
            if (arg == 1) {
                return 1;
            } else {
                System.out.println(arg);
                return arg + fibonacciSum(arg - 1);
            }
        }
    }
}
