/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author conne
 * @author Ameli
 */
public class HabitList implements CollectionInterface<Habit>{
    private ArrayList<Habit> currentHabits = new ArrayList();
   // private int currentIndex;


    public HabitList(ArrayList<Habit> currentHabits, int currentIndex) {
    this. currentHabits = currentHabits;
   // this.currentIndex = currentIndex;
    }
    
    public HabitList()
    {
        testArrayList();
    }

    public void addHabit(String name, String description){
        Habit newHabit = new Habit(name, description);
        currentHabits.add(newHabit);
    }
    public ArrayList testArrayList(){
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