/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sarah
 */
public abstract class User implements Serializable
{

    String firstName;
    String lastName;
    String username;
    String password;

    public User(String firstName, String lastName, String username, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public boolean passwordMatch(String s1, String s2)
    {
        boolean match = false;
        if (s1.equals(s2))
        {
            match = true;
        }
        return match;

    }

    public boolean updatePassword(String newPassword)
    {
        boolean check = false;
        String errorMsg = "New password must be at least eight characters and contain at least one number and one special character (!@#$%^&*).";
        if (newPassword.length() >= 8)
        {
            Pattern num = Pattern.compile("[0123456789]");
            Pattern specialChar = Pattern.compile("[!@#$%^&*]");
            Matcher hasNum = num.matcher(newPassword);
            Matcher hasSpecial = specialChar.matcher(newPassword);
            Boolean numCheck = hasNum.find();
            Boolean specialCheck = hasSpecial.find();

            if (numCheck && specialCheck)
            {
                this.password = newPassword;
                check = true;
//            } else
//            {
//                System.out.println(errorMsg);
//                if (!numCheck)
//                {
//                    System.out.print("Add a number. ");
//                }
//                if (!specialCheck)
//                {
//                    System.out.print("Add a special character. ");
//                }
//
//            }
//        } else
//        {
//            System.out.println(errorMsg);
//            System.out.println("Password is too short.");
            }
        }
        return check;
    }
    
    public String getUsername(){
        return username;
    }

    public abstract boolean setUsername(String username);
}
