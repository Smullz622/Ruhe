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
    private String goals;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    String birthDate;

    public PersonalUser(String firstName, String lastName, String username, String password, int birthMonth, int birthDay, int birthYear, String goals)
    {
        super(firstName, lastName, username, password);
        this.goals = goals;
        this.birthDate = dateToString(birthDay, birthMonth, birthYear);        
    }
    
    @Override
    public void setUsername(String newUsername)
    {
        if (newUsername.length() >= 6)
        {
            this.username = newUsername;
        }
        else
        {
            System.out.print("Username must be at least six characters");
        }
    }    

    @Override
    public String dateToString(int day, int month, int year)
    {
        String date =  String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
        return date;
    }
}
