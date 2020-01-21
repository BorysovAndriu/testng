package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorRevertTest {

    private Calculator calculator = new Calculator();

    @Test()
    public void testRevert(){

        //GIVEN

        BigDecimal a = BigDecimal.valueOf(30);
        BigDecimal b = BigDecimal.valueOf(60);

        calculator.setValue(a);
        calculator.add(b);
        calculator.revert();

        Assert.assertEquals(calculator.getCurrentAmount(), a);
    }
}
