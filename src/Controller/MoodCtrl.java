/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mood;
import Model.MoodColor;
import Model.MoodColorList;
import Model.MoodList;
import View.MoodUI;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Sarah
 */
public class MoodCtrl
{
    Mood mood;
    MoodColor moodcolor;
    MoodColorList colorList;
    MoodList moodListModel;
    ArrayList<Mood> moodList;
    MoodUI chart;
    int[] degreeArray;

    public MoodCtrl()
    {
        moodListModel = new MoodList();
        moodList = moodListModel.getMoodList();
        
        createMoodArray();
        createChart(degreeArray);
    }
    
    public void createChart(int[] degreeArray){
        JFrame f = new JFrame("Piechart");
        chart = new MoodUI(degreeArray);

        f.add(chart);
        chart.setPreferredSize(new Dimension(400, 400));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.repaint();
    }

    private void createMoodArray()
    {
        //create array of ints giving the number of degrees for each mood wedge
        //take number of occurances of each mood and return as int array where # is proprotional to 360
        // number of mood occurances/total mood occurances x 360
        //for last one, do 360 - other two
        int redCount = 0;
        int blueCount = 0;
        int yellowCount = 0;
        int redDegree, blueDegree, yellowDegree;
        
        for (int i = 0; i < moodList.size(); i++)
        {
            if (moodList.get(i).getColor().getColor().equals("red"))
            {
                redCount += 1;
            }if (moodList.get(i).getColor().getColor().equals("blue"))
            {
                blueCount += 1;
            }
            if (moodList.get(i).getColor().getColor().equals("yellow"))
            {
                yellowCount += 1;
            }
            
        }
        
        redDegree = 360 * redCount / moodList.size();
        blueDegree = 360 * blueCount / moodList.size();
        yellowDegree = 360 - redDegree - blueDegree;
        
        degreeArray = new int[]{redDegree, blueDegree, yellowDegree};
        
    }
    
    
}

//things to do:
//add pie chart to a panel instead of the frame
//creat other panels with buttons (copy habit panels)
