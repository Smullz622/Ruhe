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
public class LoginTest
{
    
    public LoginTest()
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
     * Test of validateUsername method, of class Login.
     */
    @Test
    public void testValidateUsername()
    {
        System.out.println("validateUsername");
        String inputUsername = "ReadingIsCool";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.validateUsername(inputUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassword method, of class Login.
     */
    @Test
    public void testValidatePassword()
    {
        System.out.println("validatePassword");
        String inputUsername = "BoyWhoLived";
        String inputPassword = "Gryffind0r!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.validatePassword(inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
