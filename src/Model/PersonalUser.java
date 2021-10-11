/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sarah
 */
public class PersonalUser extends User
{
    private String goals;

    public PersonalUser(String firstName, String lastName, String username, String password, String goals)
    {
        super(firstName, lastName, username, password);
        this.goals = goals;
    }
    
    @Override
    public void setUsername(String newUsername)
    {
/* There will also be a validate username method in Login Class which controls all user credentials.
 * That method will need to be called on all username changes to make sure it is unique.
 */
        if (newUsername.length() >= 6)
        {
            this.username = newUsername;
        }
        else
        {
            System.out.print("Username must be at least six characters");
        }
    }    
}
