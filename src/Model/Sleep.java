/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Sarah
 */
public class Sleep implements DateConversionInterface, Serializable
{
    private String date;
    private int sleepHours, sleepMinutes, totalTime, month, day, year, hoursRounded;
    float minsDivd;

    public Sleep(int month, int day, int year, int sleepHours, int sleepMinutes)
    {
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = dateToString(day, month, year);
        this.sleepHours = sleepHours;
        this.sleepMinutes = sleepMinutes;
        totalTime = convertTime(sleepHours, sleepMinutes);
        getTotalTime();
        
    }

     public Sleep()
    {
        this.date = "";
        this.sleepHours = 0;
        this.sleepMinutes = 0;
        totalTime = 0;
    }
//converts time to minutes
    public int convertTime(int sleepHours, int sleepMinutes)
    {
        int time = (sleepHours*60) + sleepMinutes;
        return time;
    }

    public int getTotalTime()
    {
        minsDivd = ((float) totalTime)/60;
        hoursRounded = Math.round(minsDivd);
        return hoursRounded;
    }
//sets total time in minutes
    public void setTotalTime(int hours, int minutes)
    {
        totalTime = convertTime(hours, minutes);
    }

    @Override
    public String dateToString(int day, int month, int year) {
        String date =  String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
        return date;
    }

    @Override
    public String toString()
    {
        return "date = " + date + ", hours = " + sleepHours + ", minutes = " + sleepMinutes + ", total time = " + totalTime + ", mins Divd = " + minsDivd + ", totalHours" + hoursRounded;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }



}