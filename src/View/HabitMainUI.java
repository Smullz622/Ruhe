/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.HabitController;
import Model.HabitTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
/**
 *
 * @author Sarah
 */
public class HabitMainUI extends javax.swing.JFrame
{

    private JPanel tablePanel, buttonPanel, northPanel, checkInPanel;
    private JLabel header, date, spacer1, spacer2, spacer3, spacer4, spacer5;
    private JTable habitTable;
    public JButton homeButton;
    public JButton editButton, newButton, deleteButton;
    public JButton checkInBtn;
    public JSpinner monthSpinner, daySpinner, yearSpinner;
    public JComboBox checkInBox;
    private JScrollPane tableScroller;
    private HabitController habitCtrl;
    private HabitTableModel habitTableModel;
    
    public HabitMainUI(HabitController habitCtrl)
    {
        this.habitCtrl = habitCtrl;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

                          
    private void initComponents()
    {
String[] columnNames = {"Habit", "Descripion", "Success Percentage"};
        tablePanel = new JPanel(new GridLayout(2, 1));
        checkInPanel = new JPanel();
        date = new JLabel();
        date.setText("Date (mm/dd/yyyy):");
        checkInBtn = new JButton("Check In");
        checkInBox = new JComboBox();
        checkInBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no", "yes" }));
        setSpinners();        
        checkInPanel.add(date);
        checkInPanel.add(monthSpinner);
        checkInPanel.add(daySpinner);
        checkInPanel.add(yearSpinner);
        checkInPanel.add(checkInBox);
        checkInPanel.add(checkInBtn);    
        
        northPanel = new JPanel(new GridLayout(2, 5));
        header = new JLabel();        
        spacer1 = new JLabel();
        spacer2 = new JLabel();
        spacer3 = new JLabel();
        spacer4 = new JLabel();
        spacer5 = new JLabel();
        
        buttonPanel = new JPanel(new GridLayout(1, 3));
        habitTable = new JTable(habitCtrl.getHabitTable());
        habitTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        habitTable.getColumnModel().getColumn(1).setPreferredWidth(75);
        habitTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        TableColumn tc = habitTable.getColumnModel().getColumn(0);
        tc.setHeaderValue(columnNames[0]);
        TableColumn tc2 = habitTable.getColumnModel().getColumn(1);
        tc2.setHeaderValue(columnNames[1]);
        TableColumn tc3 = habitTable.getColumnModel().getColumn(2);
        tc3.setHeaderValue(columnNames[2]);
        homeButton = new JButton("Home");
        
        header.setText("Habit");
        northPanel.add(homeButton);
        northPanel.add(spacer1);
        northPanel.add(header);
        northPanel.add(spacer2);
        northPanel.add(spacer3);
        northPanel.add(spacer4);
        northPanel.add(spacer5);
        
        editButton = new JButton("Edit");
        newButton = new JButton("New");
        deleteButton = new JButton("Delete");
        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        tableScroller = new JScrollPane(habitTable);
        habitTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
                  
        tablePanel.add(checkInPanel);
        
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(northPanel, BorderLayout.NORTH);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        
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
        public JTable getHabitTable()
        {
            return habitTable;
        }
    }                       
