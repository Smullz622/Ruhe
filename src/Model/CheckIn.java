/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author conne
 */
public class CheckIn implements DateConversionInterface {
    private int day, month, year;
    private String date;
    private boolean completed;

    public CheckIn(int day, int month, int year, boolean completed){
        this.day = day;
        this.month = month;
        this.year = year;
        this.date = dateToString(day, month, year);
        this.completed = completed;
    }


    /**
     * @param completed the completed to set
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * @return the completed
     */
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String dateToString(int day, int month, int year)
    {
        String date =  String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
        return date;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "CheckIn{" + "day=" + day + ", month=" + month + ", year=" + year + ", date=" + date + ", completed=" + completed + '}';
    }




}