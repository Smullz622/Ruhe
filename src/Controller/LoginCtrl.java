/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Login;
import View.LoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sarah
 */
public class LoginCtrl
{
    LoginUI loginUI;
    Login login;
    boolean validLogin = false;

    public LoginCtrl()
    {
        loginUI = new LoginUI();
        login = new Login();
        loginButtons();
    }

    public void loginButtons()
    {
        loginUI.loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = loginUI.userNameText.getText();
                String password = loginUI.passwordText.getText();
                if (login.validateUsername(username) && login.validatePassword(username, password))
                {
                    loginUI.setVisible(false);
                    validLogin = true;
                }
            }
            
        });
    }
    
    public boolean getValidLogin()
    {
        return validLogin;
    }
    
    
    
}
