package com.mathodcoast;

/**
 * Symbol '`' means abs function.
 * Symbol '√' means sqrt
* */

public class Calculation {

    /** №1
     * This method calculates "(a+4b)(a−3b)+a`2"  expression with @param a and b.
    * */
    public static int calculateValueOfExpression_1(int a,int b) {
        return (a + 4 * b) * (a - 3 * b) + a * a;
    }

    /** №2
     * This method calculates "|x|+x`5" expression with @param x.
    * */
    public static double calculateValueOfExpression_2(int x) {
        return Math.abs(x) + Math.pow(x,5);
    }

    /** №3
     * This method calculates "(x+1)`2+3(x+1)" expression with @param x.
    * */
    public static double calculateValueOfExpression_3(double x) {
        return Math.pow(x + 1, 2) + 3 * (x + 1);
    }

    /** №4
     * This method calculates "(|x−5|−sinx)/3+√(x`2+2014)cos2x−3" expression with @param x.
    * */
    public static double calculateValueOfExpression_4(double x) {
        return (Math.abs(x - 5) - Math.sin(x)) / 3 + Math.sqrt(x * x + 2014) * Math.cos(2 * x) - 3;
    }

    /** №5
     * This method calculates "e`(x−2)+|sin(x)|−x`4⋅cos(1/x)" expression with @param x.
    * */
    public static double calculateValueOfExpression_5(double x) {
        return Math.exp(x - 2) + Math.abs(Math.sin(x)) - Math.pow(x, 4) * Math.cos(1 / x);
    }

    /** №6
     * This method calculates "√`5(x`2+b)−(b`2sin`3(x+a))/x" expression with @params a,b,x.
    * */
    public static double calculateValueOfExpression_6(double a,double b,double x) {
        return Math.pow((x * x + b), 0.2) - (b * b * Math.pow((Math.sin(x + a)), 3)) / x;
    }
}
