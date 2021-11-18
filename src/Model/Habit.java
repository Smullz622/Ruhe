/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author conne
 */
public class Habit {
    private String habitName;
    private String description;
    private HashMap<String, CheckIn> checks;
    private int successPercent;


    public Habit(String habitName, String description){
        this.habitName = habitName;
        this.description = description;
        this.checks = new HashMap<>();
        this.successPercent = 0;

    }
    public Habit(){
        habitName = "New Habit";
        description = "Select and click edit to change";
        checks = new HashMap<>();
        successPercent = 0;
    }

    public void addCheckIn(int month, int day, int year, boolean completed){
        CheckIn newCheck = new CheckIn(month, day, year, completed);
        checks.put(newCheck.getDate(), newCheck);
        int percentage = calculateSuccess();
        }

    public void createTestList(){
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
        getChecks().put(ck0.getDate(), ck0);
        getChecks().put(ck1.getDate(), ck1);
        getChecks().put(ck2.getDate(), ck2);
        getChecks().put(ck3.getDate(), ck3);
        getChecks().put(ck4.getDate(), ck4);
        getChecks().put(ck5.getDate(), ck5);
        getChecks().put(ck6.getDate(), ck6);
        getChecks().put(ck7.getDate(), ck7);
        getChecks().put(ck8.getDate(), ck8);
        getChecks().put(ck9.getDate(), ck9);
        calculateSuccess();
    }


//    int i = 0;
    public int calculateSuccess(){
        int total = checks.size();
        int complete = 0;
        for (CheckIn value : checks.values())
        {
            if (value.isCompleted() == true)
            {
                complete += 1;
            }
        }
//        for (int i = 0; i<checks.size(); ++i)
//        {
//            if (checks.get(i).isCompleted()==true)
//            {
//                complete += 1;
//            }
//        }
        successPercent = complete*100/total;
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
    public HashMap<String, CheckIn> getChecks() {
        return checks;
    }

    /**
     * @param checks the checks to set
     */
    public void setChecks(HashMap<String, CheckIn> checks) {
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

    @Override
    public String toString()
    {
        return "Habit{" + "habitName=" + habitName + ", description=" + description + ", checks=" + checks + ", successPercent=" + successPercent + '}';
    }




}