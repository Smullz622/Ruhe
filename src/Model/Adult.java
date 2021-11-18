package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarah
 */
public class Adult extends PersonalUser {

    public Adult(String firstName, String lastName, String username, String password, int birthMonth, int birthDay, int birthYear, String goals)
    {
        super(firstName, lastName, username, password, birthMonth, birthDay, birthYear, goals);
        String birthDate = dateToString(birthDay, birthMonth, birthYear);
        verifyAge();
    }

    public void verifyAge(){
        if (birthDate.compareTo("2003/10/14")<0)
        {
            System.out.print("User is an adult.");
        }
        else{
            System.out.print("too young");
        }
    }

    public String getBirthDate()
    {
        return birthDate;
    }
}
