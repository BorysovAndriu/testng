package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class CalculatorHistoryTest {

    private Calculator calculator = new Calculator();

    @Test()
    public void testHistory(){

        //GIVEN

        BigDecimal a = BigDecimal.valueOf(30);
        BigDecimal b = BigDecimal.valueOf(60);

        calculator.setValue(b);
        calculator.add(a);

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(90));

        Assert.assertTrue(calculator.getOperationsHistory().get(0).toString().contains("AddOperation[60, 30]"));
    }
}
