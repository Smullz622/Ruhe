/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruhe;

import Model.PersonalUser;
import Model.User;

/**
 *
 * @author Sarah
 */
public class App
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        User test = new PersonalUser("Sarah", "Smullz", "Smullz622", "T3stP@ss", "None");
        test.updatePassword("testpass6%");
    }
    
}
