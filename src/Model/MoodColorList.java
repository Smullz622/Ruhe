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
public class MoodColorList {
    private ArrayList<MoodColor> colorList;
        
    public MoodColorList(ArrayList<MoodColor> colorList, int currentIndex){
        this.colorList = new ArrayList<>();
    }
    public MoodColorList(){
        createColorList();
    }
    public void addMoodColor(String color, String name, String description){
        MoodColor newColor = new MoodColor(color, name, description);
        getColorList().add(newColor);
    }
    public void editMoodColor(int currentIndex, String color, String name, String description){
        getColorList().set(currentIndex, new MoodColor(color, name, description)); 
    }
    public void deleteMoodColor(int currentIndex){
        MoodColor extraColor = getColorList().get(currentIndex);
        getColorList().remove(extraColor);
    }
    public ArrayList createColorList(){
        MoodColor red = new MoodColor("red", "Angry", "You feel like you want to hit something.");
        MoodColor blue = new MoodColor("blue", "Sad", "you feel like your heart is sinking. You want to cry.");
        MoodColor yellow = new MoodColor("yellow", "Happy", "You feel content, everything is good.");
        getColorList().add(red);
        getColorList().add(blue);
        getColorList().add(yellow);
        return getColorList();
    }

    /**
     * @return the colorList
     */
    public ArrayList<MoodColor> getColorList() {
        return colorList;
    }
    
}
