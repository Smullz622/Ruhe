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
 * @author conne
 */
public class HabitList
{

    private ArrayList<Habit> currentHabits = new ArrayList();
    private String habitFileName = "habitFile.ser";
    // private int currentIndex;

    public HabitList(ArrayList<Habit> currentHabits, int currentIndex)
    {
        this.currentHabits = currentHabits;
        // this.currentIndex = currentIndex;
    }

    public HabitList()
    {
        testArrayList();
        readHabitFile();
        if (currentHabits.isEmpty() || currentHabits == null)
        {
            testArrayList();
            writeHabitFile();
            readHabitFile();
        }
        printHabitList();
    }

    public void readHabitFile()
    {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try
        {
            fis = new FileInputStream(habitFileName);
            in = new ObjectInputStream(fis);
            currentHabits = (ArrayList) in.readObject();
            in.close();
            if (!currentHabits.isEmpty())
            {
                System.out.println("There are habits in the file");
            }
        } catch (FileNotFoundException fne)
        {
            System.out.println("File not found");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public void writeHabitFile()
    {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream(habitFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(currentHabits);
            out.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void printHabitList()
    {
        System.out.println("These are the habits in the list: ");
        for (int i = 0; i < currentHabits.size(); i++)
        {
            System.out.println(currentHabits.get(i).toString());
        }
    }

    public void addHabit(String name, String description)
    {
        Habit newHabit = new Habit(name, description);
        currentHabits.add(newHabit);
    }

    public ArrayList testArrayList()
    {
        Habit water = new Habit("Water", "Drink 8 glasses of water a day");
        Habit run = new Habit("Run", "Run 3 miles each day");
        Habit meditate = new Habit("Meditate", "Meditate for 30 minutes a day");
        currentHabits.add(water);
        currentHabits.add(run);
        currentHabits.add(meditate);
        return currentHabits;
    }

    public ArrayList<Habit> getHabitList()
    {
        return currentHabits;
    }

}
