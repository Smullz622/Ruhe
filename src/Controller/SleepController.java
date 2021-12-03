/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Sleep;
import Model.SleepList;
import View.SleepChart;
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
    
    public SleepController()
    {
        
        sleepChart = new SleepChart(new int[]{6, 7, 8, 8, 6});
    }
    
}
