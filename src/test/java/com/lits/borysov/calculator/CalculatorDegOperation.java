package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorDegOperation {

    private Calculator calculator = new Calculator();

    @Test()
    public void testDegHistory(){

        //GIVEN
        BigDecimal a = BigDecimal.valueOf(30);

        calculator.setValue(a);

        calculator.convertToDEG();

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(1710));
    }
}
