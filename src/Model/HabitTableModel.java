/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author conne
 */
public class HabitTableModel extends AbstractTableModel{
    private String[] columnNames = {"Habit Name", "Description", "Success Percentage"};
    private ArrayList<Habit>habitArrayList;

    public HabitTableModel(ArrayList<Habit> newHabitArrayList){
        habitArrayList = newHabitArrayList;
    }

    @Override
    public int getRowCount() {
        return habitArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return (Object) habitArrayList.get(row).getHabitName();
            case 1: return (Object) habitArrayList.get(row).getDescription();
            case 2: return (Object) habitArrayList.get(row).getSuccessPercent();
            default: return null;
        }
    }

    public void setTable(ArrayList<Habit> habitList){
            this.habitArrayList = habitList;
        }

}