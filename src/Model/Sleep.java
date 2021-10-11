/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sarah
 */
public class Sleep
{
    private String date;
    private int sleepHours;
    private int sleepMinutes;
    private int totalTime;

    public Sleep(String date, int sleepHours, int sleepMinutes)
    {
        this.date = date;
        this.sleepHours = sleepHours;
        this.sleepMinutes = sleepMinutes;
        totalTime = convertTime(sleepHours, sleepMinutes);
    }
    
     public Sleep()
    {
        this.date = "";
        this.sleepHours = 0;
        this.sleepMinutes = 0;
        totalTime = 0;
    }

    public int convertTime(int sleepHours, int sleepMinutes)
    {
        int time = (sleepHours*60) + sleepMinutes;
        return time;
    }
    
    public int getTotalTime()
    {
        return totalTime;
    }
    
    public void setTotalTime(int hours, int minutes)
    {
        totalTime = convertTime(hours, minutes);
    }

    @Override
    public String toString()
    {
        return "date = " + date + ", hours = " + sleepHours + ", minutes = " + sleepMinutes + ", total time = " + totalTime;
    }
      
    
    
}
