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
public class MoodColor {
    private String color, moodName, description;

    public MoodColor(String color, String moodName, String description){
        this.color = color;
        this.moodName = moodName;
        this.description = description;
    }
    public MoodColor(){
        color = "";
        moodName = "";
        description = "";
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the moodName
     */
    public String getMoodName() {
        return moodName;
    }

    /**
     * @param moodName the moodName to set
     */
    public void setMoodName(String moodName) {
        this.moodName = moodName;
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