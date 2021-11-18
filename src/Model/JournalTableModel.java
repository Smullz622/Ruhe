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
public class JournalTableModel extends AbstractTableModel{
    private String[] columnNames = {"Date", "Journal Entries"};
    private ArrayList<Journal>journalArrayList;
    
    public JournalTableModel(ArrayList<Journal> newJournalArrayList) {
        journalArrayList = newJournalArrayList;
    }

    @Override
    public int getRowCount() {
        return journalArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public String[] getColumnNames()
    {
        return columnNames;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return (Object) journalArrayList.get(row).getDate();
            case 1: return (Object) journalArrayList.get(row).getDescription().substring(0,25);
            default: return null;
        }
    }
    
    public void setTable(ArrayList<Journal> journalList)
    {
        this.journalArrayList = journalList;
    }
    
}
