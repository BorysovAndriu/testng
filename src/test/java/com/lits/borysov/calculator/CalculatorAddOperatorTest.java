package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorAddOperatorTest {

    private Calculator calculator = new Calculator();

    @Test(expectedExceptions = {AssertionError.class})
    public void testExpectedException(){

        calculator.reset();

        calculator.setValue(BigDecimal.valueOf(20.0));

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);
    }

    @Test(groups = {"calculator", "add", "single-operation"},
            description = "Verify that add operation is being perform correct")
    public void testAdd(){

        //GIVEN
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(a);

        Assert.assertEquals(calculator.getCurrentAmount(), a);

        calculator.add(b);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));

    }

    @Test(description = "Verify that division operation is being perform correct")
    public void testDivision(){

        //GIVEN
        int a = 3;
        int b = 6;

        //WHEN
        calculator.setValue(BigDecimal.valueOf(b));

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(b));

        //WHEN
        calculator.divide(BigDecimal.valueOf(a));

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(),BigDecimal.valueOf(2));
    }

    @Test(description = "Verify that multiplication operation is being perform correct")
    public void testMultiplication(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(3);
        BigDecimal b = BigDecimal.valueOf(6);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.multiply(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(),BigDecimal.valueOf(18));
    }

    @Test(description = "Verify that subtraction operation is being perform correct")
    public void testSubtraction(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(0.5);
        BigDecimal b = BigDecimal.valueOf(0.5);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.subtract(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(),BigDecimal.valueOf(0.0));
    }
}
