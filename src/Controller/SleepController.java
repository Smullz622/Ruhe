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
                int month = (int) sleepUI.monthSpinner.getValue();
                int day = (int) sleepUI.daySpinner.getValue();
                int year = (int) sleepUI.yearSpinner.getValue();
                int hours = (int) sleepUI.hoursSpinner.getValue();
                int mins = (int) sleepUI.minsSpinner.getValue();
                sleepMain.addItem(new Sleep(month, day, year, hours, mins));
                sleepTimes = sleepMain.getSleepTimes();
                sleepUI.setChart(sleepTimes);                
                sleepUI.repaint();
            }
            
        });
    }
    
}
