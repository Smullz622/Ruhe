/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Journal;
import Model.JournalMain;
import Model.JournalTableModel;
import View.JournalEntryUI;
import View.JournalMainUI;
import View.MainUI;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javax.swing.table.TableModel;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class JournalController
{

//    @FXML
//    private Button homeBtn;
//    @FXML
//    private TableColumn<?, ?> dateCol;
//    @FXML
//    private TableColumn<?, ?> entryCol;
//    @FXML
//    private Button editBtn;
//    @FXML
//    private Button newEntryBtn;
    JournalMainUI mainUI;
    JournalMain journalMain = new JournalMain();
    JournalTableModel journalTable;
    JournalEntryUI entryUI;
    ArrayList<Journal> journalArrayList;
    int selectedRow;
    boolean homepageVisible;

    public JournalController()
    {
        homepageVisible = false;
        journalArrayList = journalMain.getTheJournalList();
        journalTable = new JournalTableModel(journalArrayList);
        mainUI = new JournalMainUI(this);
        mainUI.setVisible(true);
        entryUI = new JournalEntryUI();
        entryUI.setVisible(false);
        mainButtons();
        entryButtons();
    }

    public TableModel getJournalTable()
    {
        return journalTable;
    }

    public void getJournalEntryUI(Journal journal)
    {
        entryUI = new JournalEntryUI(journal);
        entryUI.setVisible(true);
        mainUI.setVisible(false);
        entryButtons();
    }

    public ArrayList getJournalArrayList()
    {
        return journalArrayList;
    }

    public JournalMainUI getMainUI()
    {
        return mainUI;
    }

    public void mainButtons()
    {
        mainUI.deleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                int selectedTableRow = mainUI.getJournalTable().getSelectedRow();
                int selectedModelRow = mainUI.getJournalTable().convertRowIndexToModel(selectedTableRow);
                journalArrayList.remove(selectedModelRow);
                journalMain.writeJournalFile();
                mainUI.repaint();
            }

        });

        mainUI.editButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                int selectedTableRow = mainUI.getJournalTable().getSelectedRow();
                selectedRow = mainUI.getJournalTable().convertRowIndexToModel(selectedTableRow);
                Journal entry = journalArrayList.get(selectedRow);
                getJournalEntryUI(entry);
            }

        });

        mainUI.newButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                journalArrayList.add(new Journal());
                mainUI.repaint();
            }

        });
//        mainUI.homeButton.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e)
//            {
//                mainUI.setVisible(false);
//                homepageVisible = true;
//            }
//            
//        });

    }

    public void entryButtons()
    {
        entryUI.journalMainBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                mainUI.setVisible(true);
                entryUI.setVisible(false);
            }

        });

        entryUI.updateBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                int month = (int) entryUI.monthSpinner.getValue();
                int day = (int) entryUI.daySpinner.getValue();
                int year = (int) entryUI.yearSpinner.getValue();
                journalArrayList.get(selectedRow).setMonth(month);
                journalArrayList.get(selectedRow).setDay(day);
                journalArrayList.get(selectedRow).setYear(year);
                String date = journalArrayList.get(selectedRow).dateToString(day, month, year);
                journalArrayList.get(selectedRow).setDate(date);
                String text = entryUI.entryBox.getText();
                if (text.length()<26)
                {
                    entryUI.entryBox.setText(text + "                          ");
                }
                journalArrayList.get(selectedRow).setDescription(entryUI.entryBox.getText());
                journalTable.setTable(journalArrayList);
                journalMain.writeJournalFile();
                mainUI.repaint();
            }

        });        
//        entryUI.homeBtn.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e)
//            {
//                entryUI.setVisible(false);
//                homepageVisible = true;
//            }
//            
//        });
    }

    public JournalEntryUI getEntryUI()
    {
        return entryUI;
    }

    public boolean getVisible()
    {
        return homepageVisible;
    }
//    public void start(Stage stage) 
//    {
//        Parent root = null;
//        try
//        {
//            root = FXMLLoader.load(getClass().getResource("JournalMainUI.fxml"));
//        } catch (IOException ex)
//        {
//            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//    @FXML
//    private void buttons(ActionEvent event)
//    {
//    }
}
