/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Login;
import Model.PersonalUser;
import Model.User;
import View.LoginUI;
import View.UserUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sarah
 */
public class LoginCtrl
{
    LoginUI loginUI;
    UserUI userUI;
    Login login;
    boolean validLogin = false;

    public LoginCtrl()
    {
        loginUI = new LoginUI();
        userUI = new UserUI();
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
                else
                {
                    loginUI.getErrorMsg().setText("Incorrect username and/or password");
                }
            }
            
        });
        
        loginUI.createUserButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loginUI.setVisible(false);
                userUI.reset();
                userUI.setVisible(true);               
                userDetailButtons();
            }
            
        });
    }
    
    public boolean getValidLogin()
    {
        return validLogin;
    }

    private void userDetailButtons()
    {
        userUI.backBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loginUI.setVisible(true);                
                loginUI.reset();
                userUI.setVisible(false);
            }
            
        }
        );
        
        userUI.enterNewUserBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean valid = false;
                String firstName = userUI.firstNameText.getText();
                String lastName = userUI.lastNameText.getText();
                int birthMonth = (Integer) userUI.monthSpinner.getValue();
                int birthDay = (Integer) userUI.daySpinner.getValue();
                int birthYear = (Integer) userUI.yearSpinner.getValue();
                String username = userUI.usernameText.getText();
                String password1 = userUI.createPasswordText.getText();
                String password2 = userUI.reenterPasswordText.getText();
                String email = userUI.emailText.getText();
                
                User newUser = new PersonalUser(firstName, lastName, username, password1, birthMonth, birthDay, birthYear, email);
                             
                if (login.getValidUsers().containsKey(newUser.getUsername()))
                {
                    userUI.getConfirmationMsg().setText("Username already exists. Try again.");
                }
                else if (!newUser.passwordMatch(password1, password2))
                {
                    userUI.getConfirmationMsg().setText("Passwords do not match");
                }
                else if (!newUser.setUsername(username))
                {
                    userUI.getConfirmationMsg().setText("Username must be at least 6 characters.");
                }   
                else if (!newUser.updatePassword(password2))
                {
                    userUI.getConfirmationMsg().setText("Password must contain at least 8 characters, a number, and a special character.");
                }                
                else{
                    login.getValidUsers().put(username, newUser);
                    userUI.getConfirmationMsg().setText("Account created successfully");
                }
            }            
            
        });
    }
    
    
    
}
