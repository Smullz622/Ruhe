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
public class Habit {
    private String habitName;
    private String description;
    private ArrayList<CheckIn> checks;
    private int successPercent;
   
    
    public Habit(String habitName, String description){
        this.habitName = habitName;
        this.description = description;
        this.checks = new ArrayList<>();
        this.successPercent = 0;
        
    }
    public Habit(){
        habitName = "";
        description = "";
        checks = new ArrayList<>();
        successPercent = 0;
    }
    
    public void addCheckIn(int month, int day, int year, boolean completed){
        getChecks().add(new CheckIn(month, day, year, completed));
        
        }
    
    public ArrayList createTestList(){
        CheckIn ck0 = new CheckIn(10, 1, 2021, true);
        CheckIn ck1 = new CheckIn(10, 2, 2021, true);
        CheckIn ck2 = new CheckIn(10, 3, 2021, true);
        CheckIn ck3 = new CheckIn(10, 4, 2021, true);
        CheckIn ck4 = new CheckIn(10, 5, 2021, false);
        CheckIn ck5 = new CheckIn(10, 6, 2021, false);
        CheckIn ck6 = new CheckIn(10, 7, 2021, true);
        CheckIn ck7 = new CheckIn(10, 8, 2021, false);
        CheckIn ck8 = new CheckIn(10, 9, 2021, true);
        CheckIn ck9 = new CheckIn(10, 10, 2021, true);
        getChecks().add(ck0);
        getChecks().add(ck1);
        getChecks().add(ck2);
        getChecks().add(ck3);
        getChecks().add(ck4);
        getChecks().add(ck5);
        getChecks().add(ck6);
        getChecks().add(ck7);
        getChecks().add(ck8);
        getChecks().add(ck9);
        return getChecks();
    }
    
    
    int i = 0;
    public int calculateSuccess(){
        int total = getChecks().size();
        int complete = 0;
        for (int i = 0; i < getChecks().size (); i++) {
            if (getChecks().get(i).isCompleted() == true)
              complete = complete + 1;  
        }
        setSuccessPercent(complete/total);
        return getSuccessPercent();
 
    }

    /**
     * @return the habitName
     */
    public String getHabitName() {
        return habitName;
    }

    /**
     * @param habitName the habitName to set
     */
    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the checks
     */
    public ArrayList<CheckIn> getChecks() {
        return checks;
    }

    /**
     * @param checks the checks to set
     */
    public void setChecks(ArrayList<CheckIn> checks) {
        this.checks = checks;
    }

    /**
     * @return the successPercent
     */
    public int getSuccessPercent() {
        return successPercent;
    }

    /**
     * @param successPercent the successPercent to set
     */
    public void setSuccessPercent(int successPercent) {
        this.successPercent = successPercent;
    }
      

    
    
}
