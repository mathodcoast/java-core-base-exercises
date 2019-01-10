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
    public void testBinaryOperatorExpressionWithSpaces(){
        String expressionA = "25 + 20";
        String expressionB = "25 - 20";
        String expressionC = "2 * 20";
        String expressionD = "25 / 5";

        double resultA = mathExpressionParser.calculate(expressionA);
        double resultB = mathExpressionParser.calculate(expressionB);
        double resultC = mathExpressionParser.calculate(expressionC);
        double resultD = mathExpressionParser.calculate(expressionD);
        assertEquals(45,resultA,0.1);
        assertEquals(5,resultB,0.1);
        assertEquals(40,resultC,0.1);
        assertEquals(5,resultD,0.1);
    }
}
