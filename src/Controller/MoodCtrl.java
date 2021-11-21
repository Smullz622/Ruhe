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
import View.MoodChart;
import View.MoodUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    MoodChart chart;
    MoodUI moodUI;
    int[] degreeArray;
    JPanel centerPanel, northPanel, southPanel;

    public MoodCtrl()
    {
        moodListModel = new MoodList();
        moodList = moodListModel.getMoodList();
              
        createMoodArray();
        
        moodUI = new MoodUI(degreeArray);
        addButtons();
        moodUI.setVisible(true);
    }
    
//    public void createChart(int[] degreeArray){
//        JFrame f = new JFrame("Piechart");
//        chart = new MoodUI(degreeArray);
//
//        f.add(chart);
//        chart.setPreferredSize(new Dimension(400, 400));
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        f.repaint();
//    }

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

    private void addButtons()
    {
        moodUI.addBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int month = (int) moodUI.monthSpinner.getValue();
                int day = (int) moodUI.daySpinner.getValue();
                int year = (int) moodUI.yearSpinner.getValue();
                int inputColor = moodUI.moodBox.getSelectedIndex();
                
                moodList.add(new Mood(month, day, year, inputColor));
                createMoodArray();
                chart = new MoodChart(degreeArray);
                moodUI.setChart(degreeArray);
                moodUI.repaint();                
                System.out.println(moodList.toString());
                for (int i = 0; i < degreeArray.length; i++)
                {
                    System.out.print(" controller array" +degreeArray[i] + " ");
                    System.out.print(" moodUI array "+ moodUI.getDegreeArray()[i]);
                }
                
                
                
            }
            
        });
    }
    
    
}

/*Sunday to do:
X add functinality to home button (via main controller)
-add functionality to add button (make sure to repaint pie chart)
    -test ability to update by commenting out most of sample data (makes it easier to see changes)
*/
