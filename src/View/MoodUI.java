/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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

/**
 *
 * @author Sarah
 */
public class MoodUI extends JFrame
{

    MoodChart chart;
    JPanel chartPanel, northPanel, addMoodPanel, southPanel, labelPanel;
    public JButton homeBtn, addBtn;
    public JSpinner monthSpinner, daySpinner, yearSpinner;
    private JLabel header, date, spacer1, spacer2, spacer3, mood1, mood2, mood3, mood;
    public JComboBox moodBox;
    int[] degreeArray;

    public MoodUI(int[] degreeArray)
    {
        this.degreeArray = degreeArray;
        setSpinners();
        //    createChart();
        initComponents();
    }

//    public void createChart()
//    {
//        //   JFrame f = new JFrame("Piechart");
//        chart = new MoodChart(degreeArray);
//
//        //  f.add(chart);
//       // chart.setPreferredSize(new Dimension(400, 400));
////        f.pack();
////        f.setLocationRelativeTo(null);
////        f.setVisible(true);
////        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////
////        f.repaint();
//    }
    private void initComponents()
    {
        chart = new MoodChart(degreeArray);
        chartPanel = new JPanel();
        northPanel = new JPanel(new GridLayout(2, 4));
        header = new JLabel();
        header.setText("Mood");
        spacer1 = new JLabel();
        spacer1.setText(" ");
        spacer2 = new JLabel();
        spacer2.setText(" ");
        spacer3 = new JLabel();
        spacer3.setText(" ");
        mood1 = new JLabel();
        mood1.setText(" Red = Angry ");
        mood2 = new JLabel();
        mood2.setText(" Blue = Sad ");
        mood3 = new JLabel();
        mood3.setText(" Yellow = Happy ");
        homeBtn = new JButton();
        homeBtn.setText("Home");
        northPanel.add(homeBtn);
        northPanel.add(spacer1);
        northPanel.add(header);
        northPanel.add(spacer2);
//        labelPanel = new JPanel(new GridLayout(4, 1));
//        labelPanel.add(spacer1);
//        labelPanel.add(mood1);
//        labelPanel.add(mood2);
//        labelPanel.add(mood3);
        northPanel.add(spacer3);
        northPanel.add(mood1);
        northPanel.add(mood2);
        northPanel.add(mood3);

        addMoodPanel = new JPanel();
        addBtn = new JButton();
        addBtn.setText("Add Mood");
        date = new JLabel();
        date.setText("Date (mm/dd/yyyy):");
        moodBox = new JComboBox();
        moodBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
        {
            "Angry", "Sad", "Happy"
        }));
        mood = new JLabel();
        mood.setText("     Mood: ");
        addMoodPanel.add(date);
        addMoodPanel.add(monthSpinner);
        addMoodPanel.add(daySpinner);
        addMoodPanel.add(yearSpinner);
        addMoodPanel.add(mood);
        addMoodPanel.add(moodBox);
        addMoodPanel.add(addBtn);

        southPanel = new JPanel();
//        southPanel.add(date);
//        southPanel.add(monthSpinner);
//        southPanel.add(daySpinner);
//        southPanel.add(yearSpinner);
        southPanel.add(addMoodPanel);

        this.setSize(525, 550);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(chart, BorderLayout.CENTER);
        this.getContentPane().add(northPanel, BorderLayout.NORTH);
        this.getContentPane().add(southPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setSpinners()
    {
        daySpinner = new JSpinner();
        monthSpinner = new JSpinner();
        yearSpinner = new JSpinner();
        daySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2021, 1920, 2021, 1));
        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(yearSpinner, "#");
        JSpinner.NumberEditor monthEditor = new JSpinner.NumberEditor(monthSpinner, "#");
        JSpinner.NumberEditor dayEditor = new JSpinner.NumberEditor(daySpinner, "#");
        daySpinner.setEditor(dayEditor);
        yearSpinner.setEditor(yearEditor);
        monthSpinner.setEditor(monthEditor);

    }

    public MoodChart getChart()
    {
        return chart;
    }

    public void setChart(int[] degreeArray)
    {
        this.degreeArray = degreeArray;
        chart.setValue(degreeArray);
        repaint();
    }

    public int[] getDegreeArray()
    {
        return degreeArray;
    }
}
