/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sarah
 */
public class SleepListTest
{
    
    public SleepListTest()
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
     * Test of addSleep method, of class SleepList.
     */
    @Test
    public void testAddSleep()
    {
        System.out.println("addSleep");
        Sleep sleep = new Sleep();
        SleepList instance = new SleepList();
        instance.addItem(sleep);
        Sleep expResult = new Sleep();
        Sleep result = instance.getSleepList().get(1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSleep method, of class SleepList.
     */
    @Test
    public void testDeleteSleep()
    {
        System.out.println("deleteSleep");
        int index = 0;
        SleepList instance = new SleepList();
        instance.deleteItem(index);
        int result = instance.getSleepList().size();
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editSleep method, of class SleepList.
     */
    @Test
    public void testEditSleep()
    {
        System.out.println("editSleep");
        int index = 0;
        Sleep sleep = new Sleep(9,18,2021, 7, 0);
        SleepList instance = new SleepList();
        instance.editItem(index, sleep);
        Sleep expResult = sleep;
        Sleep result = instance.getSleepList().get(0);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSleepList method, of class SleepList.
     */
    @Test
    public void testGetSleepList()
    {
        System.out.println("getSleepList");
        SleepList instance = new SleepList();
        ArrayList<Sleep> expResult = new ArrayList<Sleep>();
        expResult.add(new Sleep());
        ArrayList<Sleep> result = instance.getSleepList();
        assertEquals(expResult.toString(), result.toString());
        System.out.println(expResult);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
