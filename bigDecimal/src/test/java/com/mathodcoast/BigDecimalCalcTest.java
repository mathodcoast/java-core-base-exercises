package com.mathodcoast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith( JUnit4.class )
public class BigDecimalCalcTest {

    @Test
    public void testBigDecimalAdd(){
        BigDecimal a = new BigDecimal("0.03");
        BigDecimal b = new BigDecimal("0.04");

        BigDecimal expected = new BigDecimal("0.07");

        BigDecimal result = BigDecimalCalc.bigDecimalAdd(a, b);
        assertEquals(expected, result);
    }
}
