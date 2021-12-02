/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Habit;
import Model.HabitList;
import Model.HabitTableModel;
import Model.Journal;
import View.HabitDetailUI;
import View.HabitMainUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Sarah
 */
public class HabitController
{
    HabitTableModel habitTable;
    HabitList habitMain = new HabitList();
    ArrayList<Habit> habitArrayList;
    HabitMainUI habitUI;
    HabitDetailUI habitDetailUI;
    int selectedRow;

    public HabitController()
    {
        habitArrayList = habitMain.getHabitList();
        habitTable = new HabitTableModel(habitArrayList);        
        habitUI = new HabitMainUI(this);
        habitUI.setVisible(true);
        habitDetailUI = new HabitDetailUI();
        habitDetailUI.setVisible(false);
        mainButtons();
        detailButtons();
        
    }
    
    public HabitTableModel getHabitTable()
    {
        return habitTable;
    }

    private void mainButtons()
    {
        habitUI.deleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                int selectedTableRow = habitUI.getHabitTable().getSelectedRow();
                int selectedModelRow = habitUI.getHabitTable().convertRowIndexToModel(selectedTableRow);
                habitArrayList.remove(selectedModelRow);
                habitUI.repaint();
            }

        });
         habitUI.editButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                int selectedTableRow = habitUI.getHabitTable().getSelectedRow();
                selectedRow = habitUI.getHabitTable().convertRowIndexToModel(selectedTableRow);
                Habit selectedHabit = habitArrayList.get(selectedRow);
                habitDetailUI = new HabitDetailUI(selectedHabit);
                habitDetailUI.setVisible(true);
                habitUI.setVisible(false);
                detailButtons();
            }

        });
//
//        mainUI.editButton.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e)
//            {
//                int selectedTableRow = mainUI.getJournalTable().getSelectedRow();
//                selectedRow = mainUI.getJournalTable().convertRowIndexToModel(selectedTableRow);
//                Journal entry = journalArrayList.get(selectedRow);
//                getJournalEntryUI(entry);
//            }
//
//        });

        habitUI.newButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                habitArrayList.add(new Habit());
                habitUI.repaint();
            }

        });
        
        habitUI.checkInBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectedTableRow = habitUI.getHabitTable().getSelectedRow();
                int selectedModelRow = habitUI.getHabitTable().convertRowIndexToModel(selectedTableRow);
                int month = (int) habitUI.monthSpinner.getValue();
                int day = (int) habitUI.daySpinner.getValue();
                int year = (int) habitUI.yearSpinner.getValue();
                boolean check = false;
                if (habitUI.checkInBox.getSelectedIndex()==1)
                {
                    check = true;
                }
                habitArrayList.get(selectedModelRow).addCheckIn(month, day, year, check);
                habitUI.repaint();
            }
            
        });
    }

    private void detailButtons()
    {
        habitDetailUI.backBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                habitDetailUI.setVisible(false);
                habitUI.repaint();
                habitUI.setVisible(true);
            }
            
        });
        
        habitDetailUI.updateBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = habitDetailUI.nameBox.getText();
                String description = habitDetailUI.descriptionBox.getText();
                
                habitArrayList.get(selectedRow).setHabitName(name);
                habitArrayList.get(selectedRow).setDescription(description);
            }
            
        });
    }
}
