/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Sarah
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;


public class SleepUI extends JFrame
{
    SleepChart chart;
    JPanel headerPanel, addSleepPanel, northPanel;
    public JButton homeBtn, addBtn;
    public JSpinner monthSpinner, daySpinner, yearSpinner, hoursSpinner, minsSpinner;
    private JLabel header, date, sleep, hours, mins, spacer1, spacer2, spacer3;
    int[] sleepTimes;
    
    public SleepUI(int[] sleepTimes)
    {
        this.sleepTimes = sleepTimes;
        setSpinners();
        initComponents();
    }
    
    private void initComponents()
    {
        chart = new SleepChart(sleepTimes);
               
        headerPanel = new JPanel(new GridLayout(1, 4));
        header = new JLabel();
        header.setText("Sleep");
        spacer1 = new JLabel();
        spacer1.setText(" ");
        spacer2 = new JLabel();
        spacer2.setText(" ");
        spacer3 = new JLabel();
        spacer3.setText(" ");
        homeBtn = new JButton();
        homeBtn.setText("Home");
        headerPanel.add(homeBtn);
        headerPanel.add(spacer1);
        headerPanel.add(header);
        headerPanel.add(spacer2);
                
        addSleepPanel = new JPanel();
        addBtn = new JButton();
        addBtn.setText("Add Sleep");
        date = new JLabel();        
        date.setText("Date (mm/dd/yyyy):");
        sleep = new JLabel();
        sleep.setText("     Sleep Time: ");
        hours = new JLabel();
        hours.setText("Hours   ");
        mins = new JLabel();
        mins.setText("Minutes   ");
        addSleepPanel.add(date);
        addSleepPanel.add(monthSpinner);
        addSleepPanel.add(daySpinner);
        addSleepPanel.add(yearSpinner);
        addSleepPanel.add(sleep);
        addSleepPanel.add(hoursSpinner);
        addSleepPanel.add(hours);
        addSleepPanel.add(minsSpinner);
        addSleepPanel.add(mins);
        addSleepPanel.add(addBtn);
 
        
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(chart, BorderLayout.CENTER);
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.getContentPane().add(addSleepPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setSpinners()
    {
        daySpinner = new JSpinner();
        monthSpinner = new JSpinner();
        yearSpinner = new JSpinner();
        hoursSpinner = new JSpinner();
        minsSpinner = new JSpinner();
        daySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2021, 1920, 2021, 1));
        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        hoursSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        minsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(yearSpinner, "#");
        JSpinner.NumberEditor monthEditor = new JSpinner.NumberEditor(monthSpinner, "#");
        JSpinner.NumberEditor dayEditor = new JSpinner.NumberEditor(daySpinner, "#");
        JSpinner.NumberEditor hoursEditor = new JSpinner.NumberEditor(hoursSpinner, "#");
        JSpinner.NumberEditor minsEditor = new JSpinner.NumberEditor(minsSpinner, "#");
        daySpinner.setEditor(dayEditor);
        yearSpinner.setEditor(yearEditor);
        monthSpinner.setEditor(monthEditor);
        hoursSpinner.setEditor(hoursEditor);
        minsSpinner.setEditor(minsEditor);

    }
     public void setChart(int[] sleepTimes)
    {
        this.sleepTimes = sleepTimes;
        chart.setValue(sleepTimes);
        repaint();
    }
}

