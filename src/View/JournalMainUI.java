/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.JournalController;
import Model.Journal;
import Model.JournalTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sarah
 */
public class JournalMainUI extends JFrame
{
    private JPanel tablePanel, buttonPanel, northPanel;
    private JLabel header, spacer1, spacer2, spacer3, spacer4, spacer5;
    private JTable journalTable;
    public JButton homeButton;
    public JButton editButton;
    public JButton newButton;
    public JButton deleteButton;
    private JScrollPane tableScroller;
    private JournalController journalCtrl;
    private JournalTableModel journalTableModel;

    public JournalMainUI(JournalController journalCtrl)
    {
        this.journalCtrl = journalCtrl;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents()
    {
        String[] columnNames = {"Date", "Journal Entries"};
        tablePanel = new JPanel();
        
        northPanel = new JPanel(new GridLayout(2, 5));
        header = new JLabel();
        spacer1 = new JLabel();
        spacer2 = new JLabel();
        spacer3 = new JLabel();
        spacer4 = new JLabel();
        spacer5 = new JLabel();
        
        buttonPanel = new JPanel(new GridLayout(1, 3));
        journalTable = new JTable(journalCtrl.getJournalTable());
        journalTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        journalTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        TableColumn tc = journalTable.getColumnModel().getColumn(0);
        tc.setHeaderValue(columnNames[0]);
        TableColumn tc2 = journalTable.getColumnModel().getColumn(1);
        tc2.setHeaderValue(columnNames[1]);
        homeButton = new JButton("Home");
        
        header.setText("Journal");
        spacer1.setText("");
        spacer2.setText("");
        northPanel.add(homeButton);
        northPanel.add(spacer1);
        northPanel.add(header);
        northPanel.add(spacer2);
        northPanel.add(spacer3);
        northPanel.add(spacer4);
        northPanel.add(spacer5);
        
        editButton = new JButton("View/Edit");
        newButton = new JButton("New");
        deleteButton = new JButton("Delete");
        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
      //  buttonPanel.add(homeButton);
        buttonPanel.add(deleteButton);
        tableScroller = new JScrollPane(journalTable);
        journalTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(northPanel, BorderLayout.NORTH);
    }

    public JTable getJournalTable()
    {
        return journalTable;
    }
    
}
