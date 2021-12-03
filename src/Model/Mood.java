/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author conne
 */
public class Mood implements DateConversionInterface, Serializable{
    private int month, day, year, inputColor;
    private String date;
    private MoodColorList colorOptions;
    private MoodColor color;

    public Mood(int month, int day, int year, int inputColor) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = dateToString(day, month, year);
        this.inputColor = inputColor;
        this.colorOptions = new MoodColorList();
        convertIntToColor(inputColor);
        
    }

    public MoodColor getColor() {
        return color;
    }


    public void setColor(MoodColor color) {
        this.color = color;
    }

    public void convertIntToColor(int inputColor){
        setColor(colorOptions.getColorList().get(inputColor));
    }

    @Override
    public String dateToString(int day, int month, int year) {
        String date =  String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
        return date;
    }
    @Override
    public String toString(){
        return color.getColor() + color.getMoodName() + color.getDescription();
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
     * @return the colorOptions
     */
    public MoodColorList getColorOptions() {
        return colorOptions;
    }

    /**
     * @param colorOptions the colorOptions to set
     */
    public void setColorOptions(MoodColorList colorOptions) {
        this.colorOptions = colorOptions;
    }




}