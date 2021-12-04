/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Sleep;
import Model.SleepList;
import View.SleepChart;
import View.SleepUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Sarah
 */
public class SleepController
{
    Sleep sleep;
    SleepList sleepMain;
    ArrayList<Sleep> sleepList;
    SleepChart sleepChart;
    SleepUI sleepUI;
    int[] sleepTimes;
    
    public SleepController()
    {
        
        sleepMain = new SleepList();
        sleepList = sleepMain.getSleepList();
        sleepTimes = sleepMain.getSleepTimes();
        sleepUI = new SleepUI(sleepTimes);
        sleepUI.setVisible(true);
        addButtons();
    }

    private void addButtons()
    {
        sleepUI.addBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Add button clicked");
            }
            
        });
    }
    
}
