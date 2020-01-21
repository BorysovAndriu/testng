package com.lits.borysov.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizerTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "data")
    public void testAddTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result){
        Calculator calculator = new Calculator();

        //WHEN
        calculator.setValue(a);
        calculator.add(b);

        /*//THEN
        Assert.assertEquals(calculator.getCurrentAmount(), result);*/

        int compareresult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareresult,0);
    }

    @DataProvider(parallel = true)
    public Object [][] data(){
        return new Object[][]{
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(2.0)},
                {BigDecimal.valueOf(2.5), BigDecimal.valueOf(3.5), BigDecimal.valueOf(6.0)},
                {BigDecimal.valueOf(-3.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(-3.0)},
                {BigDecimal.valueOf(1.5), BigDecimal.ZERO, BigDecimal.valueOf(1.5)},
                {BigDecimal.valueOf(111111.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(111112.0)},
                {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(-9.0), BigDecimal.valueOf(-10.5)},
        };
    }

    @Test(dataProvider = "data1")
    public void testMultiplicationTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result){

        //WHEN
        calculator.setValue(a);
        calculator.multiply(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), result);
    }

    @DataProvider
    public Object [][] data1(){
        return new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(2.5), BigDecimal.valueOf(2), BigDecimal.valueOf(5.0)},
                {BigDecimal.valueOf(5.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(2.75)},
        };
    }

    @Test(dataProvider = "data2")
    public void testDivisionTwoTest(BigDecimal a, BigDecimal b, BigDecimal result){

        //WHEN
        calculator.setValue(a);
        calculator.divide(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), result);
    }

    @DataProvider
    public Object [][] data2(){
        return new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(4), BigDecimal.valueOf(2), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(5.5), BigDecimal.valueOf(1), BigDecimal.valueOf(5.5)},
        };
    }
}
