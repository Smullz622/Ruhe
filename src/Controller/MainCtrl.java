/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainUI;
import java.awt.event.ActionEvent;

/**
 *
 * @author Sarah
 */
public class MainCtrl
{
    MainUI homepage = new MainUI();

    public MainCtrl()
    {
        homepage.setVisible(true);
    }
    

    public void userNameTextActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void loginButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    public MainUI getHomepage()
    {
        return homepage;
    }
    
}
