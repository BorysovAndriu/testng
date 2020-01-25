package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorRadOperation {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "data")
    public void testRadConvert(BigDecimal a, String result){

        //GIVEN

        calculator.setValue(a);

        calculator.convertToRAD().toString();

        Assert.assertEquals(calculator.getCurrentAmount().toString(), result);
    }

    @DataProvider()
    public Object [][] data(){
        return new Object[][]{
                {BigDecimal.valueOf(30), "0.523598775598290"},
                {BigDecimal.valueOf(60), "1.047197551196580"},
                {BigDecimal.valueOf(90), "1.570796326794870"},
        };
    }
}
