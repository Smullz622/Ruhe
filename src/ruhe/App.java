/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruhe;

import Controller.LoginCtrl;
import Controller.MainCtrl;
import Model.Adult;
import Model.Login;
import Model.Minor;
import Model.PersonalUser;
import Model.User;
import View.MainUI;

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
        LoginCtrl login = new LoginCtrl();
        MainCtrl main = new MainCtrl();
        while (login.getValidLogin()==false)
        {
           main.getHomepage().setVisible(false);
        }
        main.getHomepage().setVisible(true);
        
    }
    
}
