/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
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
    JPanel chartPanel, northPanel, addMoodPanel;
    JButton homeBtn, addBtn;
    public JSpinner monthSpinner, daySpinner, yearSpinner;
    private JLabel header, date, spacer1, spacer2, spacer3, spacer4, spacer5;
    int[] degreeArray;
  //  JFrame f = new JFrame("Piechart");

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
        northPanel = new JPanel();
        addMoodPanel = new JPanel();
        homeBtn = new JButton();
        homeBtn.setText("Home");
        northPanel.add(homeBtn);
        addBtn = new JButton();
        addBtn.setText("Add Mood");
        date = new JLabel();
        date.setText("Date (mm/dd/yyyy):");
        addMoodPanel.add(date);
        addMoodPanel.add(monthSpinner);
        addMoodPanel.add(daySpinner);
        addMoodPanel.add(yearSpinner);
        addMoodPanel.add(addBtn);

        this.setSize(500, 550);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(chart, BorderLayout.CENTER);
      //  f.add(chart);
        this.getContentPane().add(northPanel, BorderLayout.NORTH);
        this.getContentPane().add(addMoodPanel, BorderLayout.SOUTH);
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
}
