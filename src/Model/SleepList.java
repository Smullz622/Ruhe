/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Sarah
 */
public class SleepList implements CollectionInterface<Sleep>
{
    private ArrayList<Sleep> sleepList;
    private int currentIndex;
    

    public SleepList()
    {
        this.sleepList = new ArrayList<Sleep>();
        this.currentIndex = 0;
    }
    
    public ArrayList<Sleep> getSleepList()
    {
        return sleepList;
    }

    @Override
    public void addItem(Sleep sleep)
    {
        sleepList.add(sleep);
    }

    @Override
    public void deleteItem(int index)
    {
        try{
            sleepList.remove(index);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void editItem(int index, Sleep sleep)
    {
        try{
            sleepList.set(index, sleep);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }
    
}
