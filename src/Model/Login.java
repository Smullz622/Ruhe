/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Sarah
 */
public class Login
{

    private HashMap<String, User> validUserMap = new HashMap<String, User>();

    public Login()
    {
        createTestMap();
    }
    
    
    public boolean validateUsername(String inputUsername)
    {
        boolean valid = false;
        if (validUserMap.containsKey(inputUsername))
        {
            valid = true;
        }
        return valid;
    }

    public boolean validatePassword(String inputUsername, String inputPassword)
    {
        boolean valid = false;
        if (validateUsername(inputUsername)==true)
        {
            if (validUserMap.get(inputUsername).password.equals(inputPassword))
            {
                valid = true;
            }
        }
        return valid;
    }

    private void createTestMap()
    {
        User test1 = new PersonalUser("Hermione", "Granger", "ReadingIsCool", "SP@W4ever", 9, 19, 1979, "hgranger@hogwarts.edu");
        User test2 = new PersonalUser("Harry", "Potter", "BoyWhoLived", "Gryffind0r!", 7, 31, 1980, "hpotter@hogwarts.edu");
        User test3 = new PersonalUser("Ron", "Weasley", "WeasleyIsOurKing", "C@nnons7", 3, 1, 1980, "rweasley@hogwarts.edu");
                
        validUserMap.put("ReadingIsCool", test1);
        validUserMap.put("BoyWhoLived", test2);
        validUserMap.put("WeasleyIsOurKing", test3);
    }
    
    public HashMap getValidUsers(){
        return validUserMap;
    }
}
