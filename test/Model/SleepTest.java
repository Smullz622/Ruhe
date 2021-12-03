/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sarah
 */
public class SleepTest
{
    
    public SleepTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of convertTime method, of class Sleep.
     */
    @Test
    public void testConvertTime()
    {
        System.out.println("convertTime");
        int sleepHours = 2;
        int sleepMinutes = 30;
        Sleep instance = new Sleep(9, 18, 2021, 2, 30);
        int expResult = 150;
        int result = instance.convertTime(sleepHours, sleepMinutes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalTime method, of class Sleep.
     */
    @Test
    public void testGetTotalTime()
    {
        System.out.println("getTotalTime");
        Sleep instance = new Sleep(9, 18, 2021, 1, 30);
        int expResult = 90;
        int result = instance.getTotalTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalTime method, of class Sleep.
     */
    @Test
    public void testSetTotalTime()
    {
        System.out.println("setTotalTime");
        int hours = 1;
        int minutes = 30;
        Sleep instance = new Sleep(9, 18, 2021, 0, 0);
        instance.setTotalTime(hours, minutes);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     /**
     * Test of getTotalTime method, of class Sleep.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Sleep instance = new Sleep(9, 18, 2021, 1, 30);
        String expResult = "date = 2021/09/18, hours = 1, minutes = 30, total time = 90";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
