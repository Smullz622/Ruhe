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
public class Journal implements DateConversionInterface{
    private int month, day, year;
    private String date, description;
        
    public Journal(String date, String description){
    this.date = dateToString(day, month, year);
    this.description = description;
    }

    public boolean validateEntry(){
        boolean valid = false;
        if (description != null)
            valid = true;
        return valid;
    }
    
    public boolean validateDate(){
        boolean validDate = false;
        if ((month != 0) && ((day != 0) && (year != 0))) 
            validDate = true;
        return validDate;
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

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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


}
