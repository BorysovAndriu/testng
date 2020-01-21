package com.lits.borysov.app;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @BeforeClass
    public  void beforeClass(){
        System.out.println("*** Tests Class AppTest started");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("******* Before each Tests Method");
    }

    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void firstTest()
    {
        assertEquals(10,10, "10 is not equel 4");
    }
}
