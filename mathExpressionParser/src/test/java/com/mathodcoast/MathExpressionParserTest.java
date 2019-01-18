package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class MathExpressionParserTest {
    private MathExpressionParser mathExpressionParser = new MathExpressionParser();

    @Test
    public void testBinaryOperatorExpressionWithoutSpaces(){
        String expressionA = "25+20";
        String expressionB = "25-20";
        String expressionC = "2*20";
        String expressionD = "25/5";

        double resultA = mathExpressionParser.calculate(expressionA);
        double resultB = mathExpressionParser.calculate(expressionB);
        double resultC = mathExpressionParser.calculate(expressionC);
        double resultD = mathExpressionParser.calculate(expressionD);
        assertEquals(45,resultA,0.1);
        assertEquals(5,resultB,0.1);
        assertEquals(40,resultC,0.1);
        assertEquals(5,resultD,0.1);
    }

    @Test
    public void testExpressionWithRightScopes(){
        String expressionA = "25+(20-10)";
        String expressionB = "25*(20-10)";

        double resultA = mathExpressionParser.calculate(expressionA);
        double resultB = mathExpressionParser.calculate(expressionB);

        assertEquals(35,resultA,0.1);
        assertEquals(250,resultB,0.1);
    }

    @Test
    public void testExpressionWithLeftScopes(){
        String expressionA = "(10+10)/5";

        double resultA = mathExpressionParser.calculate(expressionA);
        assertEquals(4,resultA, 0.1);
    }

    @Test
    public void testDifficultExpressionA(){
        String expression = "(25+15)*6+5";

        double result = mathExpressionParser.calculate(expression);

        assertEquals(245,result,0.1);
    }

    @Test
    public void testDifficultExpressionB(){
        String expression = "5*(50/(10-5))";

        double result = mathExpressionParser.calculate(expression);

        assertEquals(50,result,0.1);
    }

    @Test
    public void testNoScopesOnBothSidesWithScopesInBody(){
        String expression = "250/(10-5)-2";

        double result = mathExpressionParser.calculate(expression);

        assertEquals(48,result,0.1);
    }

    @Test
    public void testExpressionWithTwoDifferentScopes(){
        String expression = "(2+3)*(6+4)";

        double result = mathExpressionParser.calculate(expression);

        assertEquals(50,result,0.1);
    }
}
