package com.mathodcoast;


public class MathExpressionParser {
    public double calculate(String expression) {
        if (expression.startsWith("(") & expression.endsWith(")")){

            return calculate(expression.substring(1, expression.length() - 1));
        } else{
            if (expression.startsWith("(")){
                System.out.println(expression);
                int pos = expression.length() - 1;
                while (pos > 0) {
                    if (Character.isDigit(expression.charAt(pos))) {
                        pos--;
                    } else {
                        double leftOperand = calculate(expression.substring(0,pos));
                        char operand = expression.charAt(pos);
                        double rightOperand = Double.valueOf(expression.substring(pos + 1));
                        return makeOperation(operand,leftOperand,rightOperand);
                    }
                }
            } else if (expression.endsWith(")")){
                System.out.println(expression);
                int pos = 0;
                while (pos < expression.length()) {
                    if (Character.isDigit(expression.charAt(pos))) {
                        pos++;
                    } else {
                        double leftOperand = Double.valueOf(expression.substring(0,pos));
                        char operand = expression.charAt(pos);
                        double rightOperand = calculate(expression.substring(pos + 1));
                        return makeOperation(operand,leftOperand,rightOperand);
                    }
                }
            } else {
                System.out.println(expression);
                int pos = 0;
                while (pos < expression.length()) {
                    if (Character.isDigit(expression.charAt(pos))) {
                        pos++;
                    } else {
                        double leftOperand = Double.valueOf(expression.substring(0,pos));
                        char operand = expression.charAt(pos);
                        double rightOperand = Double.valueOf(expression.substring(pos + 1));
                        return makeOperation(operand,leftOperand,rightOperand);
                    }
                }
            }
        }
        System.out.println(expression);
        return Double.valueOf(expression);
    }

    private double makeOperation(char operand,double leftOperand,double rightOperand) {
        switch (operand){
            case '+': return leftOperand + rightOperand;
            case '-': return leftOperand - rightOperand;
            case '*': return leftOperand * rightOperand;
            case '/': return leftOperand / rightOperand;
            default: return 0;
        }
    }
}
