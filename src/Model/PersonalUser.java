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
public class PersonalUser extends User implements DateConversionInterface
{
    private String email;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    String birthDate;

    public PersonalUser(String firstName, String lastName, String username, String password, int birthMonth, int birthDay, int birthYear, String email)
    {
        super(firstName, lastName, username, password);
        this.email = email;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.birthDate = dateToString(birthDay, birthMonth, birthYear);        
    }
    
    @Override
    public boolean setUsername(String newUsername)
    {
        boolean check = false;
        if (newUsername.length() >= 6)
        {
            this.username = newUsername;
            check = true;
        }
        return check;
    }    

    @Override
    public String dateToString(int day, int month, int year)
    {
        String date =  String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
        return date;
    }

    @Override
    public String toString()
    {
        return "PersonalUser{" + "email=" + email + ", birthYear=" + birthYear + ", birthMonth=" + birthMonth + ", birthDay=" + birthDay + ", birthDate=" + birthDate + '}';
    }
    
    
}
