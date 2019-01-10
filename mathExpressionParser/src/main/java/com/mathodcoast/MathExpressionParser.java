package com.mathodcoast;

public class MathExpressionParser {
    public double calculate(String expression) {
        String numAString = "";
        String numBString = "";
        double numA = 0;
        double numB;
        char sign = '0';
        System.out.println(expression);
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (numA == 0) {
                if (Character.isDigit(character)) {
                    numAString = numAString + character;
                } else {
                    numA = Double.valueOf(numAString);
                    System.out.println(numA);
                }
            } else {
                if (Character.isDigit(character)) {
                    numBString = numBString + character;
                }
            }

            if (sign == '0' || character == '+' || character == '-' || character == '*' || character == '/') {
                sign = character;
                System.out.println(sign);
            }
        }
        numB = Double.valueOf(numBString);
        System.out.println(numB);
        switch (sign) {
            case '+':
                return numA + numB;
            case '-':
                return numA - numB;
            case '*':
                return numA * numB;
            case '/':
                return numA / numB;
            default:
                return 0;
        }
    }
}
