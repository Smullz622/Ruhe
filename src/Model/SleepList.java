/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sarah
 */
public class SleepList implements CollectionInterface<Sleep>
{
    private ArrayList<Sleep> sleepList;
    private int currentIndex;
    private String sleepFileName = "sleepFile.ser";

    public SleepList()
    {
        this.sleepList = new ArrayList<Sleep>();
        this.currentIndex = 0;
        readSleepFile();
        if(sleepList.isEmpty() || sleepList == null){
            createTestList();
            writeSleepFile();
            readSleepFile();
        }
        printSleepList();
    }
    public void readSleepFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(sleepFileName);
            in = new ObjectInputStream(fis);
            sleepList = (ArrayList)in.readObject();
            in.close();
            if(!sleepList.isEmpty()){
                System.out.println("There are sleeps in the file");
            }
        }catch(FileNotFoundException fne){
            System.out.println("File not found");
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public void writeSleepFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(sleepFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(sleepList);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void printSleepList(){
        System.out.println("These are the sleeps in the list: ");
        for(int i = 0; i<sleepList.size(); i++){
            System.out.println(sleepList.get(i).toString());
        }
    }



    public void createTestList(){
        Sleep s0 = new Sleep(11,24,2021,6,45);
        Sleep s1 = new Sleep(11,25,2021,10,30);
        Sleep s2 = new Sleep(11,26,2021,7,15);
        Sleep s3 = new Sleep(11,27,2021,7,20);
        Sleep s4 = new Sleep(11,28,2021,6,15);
        Sleep s5 = new Sleep(11,29,2021,7,30);
        sleepList.add(s0);
        sleepList.add(s1);
        sleepList.add(s2);
        sleepList.add(s3);
        sleepList.add(s4);
        sleepList.add(s5);
    }


    public ArrayList<Sleep> getSleepList()
    {
        return sleepList;
    }

    @Override
    public void addItem(Sleep sleep)
    {
        sleepList.add(sleep);
        writeSleepFile();
    }

    @Override
    public void deleteItem(int index)
    {
        try{
            sleepList.remove(index);
            writeSleepFile();
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
            writeSleepFile();
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }

}