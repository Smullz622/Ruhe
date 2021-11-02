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
 */
public class HabitList {
    private ArrayList<Habit> currentHabits;
    private int currentIndex;
    private Habit h = new Habit();
    
    public HabitList(ArrayList<Habit> currentHabits, int currentIndex) {
    this. currentHabits = currentHabits;
    this.currentIndex = currentIndex;
    }
    
    public void addHabit(){
        Habit newHabit = new Habit(h.getHabitName(), h.getDescription(), h.getChecks(), h.getSuccessPercent());
        currentHabits.add(newHabit);
    }
    public ArrayList testArrayList(){
        Habit water = new Habit("Water", "Drink 8 glasses of water a day", h.getChecks(), h.getSuccessPercent());
        Habit run = new Habit("Run", "Run 3 miles each day", h.getChecks(), h.getSuccessPercent());
        return currentHabits;
    }
    
    
}
