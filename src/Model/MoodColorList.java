/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author conne
 */
public class MoodColorList implements Serializable{
    private ArrayList<MoodColor> colorList = new ArrayList<>();
    private String colorFileName = "moodColorFile.ser";

    public MoodColorList(ArrayList<MoodColor> colorList, int currentIndex){
        this.colorList = new ArrayList<>();
    }
    public MoodColorList(){
        readMoodColorFile();
        if(colorList.isEmpty() || colorList == null){
            createColorList();
            writeMoodColorFile();
            readMoodColorFile();
        }
        printMoodColorList();
    }
        public void readMoodColorFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(colorFileName);
            in = new ObjectInputStream(fis);
            colorList = (ArrayList)in.readObject();
            in.close();
            if(!colorList.isEmpty()){
                System.out.println("There are colors in the file");
            }
        }catch(FileNotFoundException fne){
            System.out.println("File not found");
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public void writeMoodColorFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(colorFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(colorList);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void printMoodColorList(){
        System.out.println("These are the colors in the list: ");
        for(int i = 0; i<colorList.size(); i++){
            System.out.println(colorList.get(i).toString());
        }
    }
    
    public void addMoodColor(String color, String name, String description){
        MoodColor newColor = new MoodColor(color, name, description);
        getColorList().add(newColor);
        writeMoodColorFile();
    }
    public void editMoodColor(int currentIndex, String color, String name, String description){
        getColorList().set(currentIndex, new MoodColor(color, name, description)); 
        writeMoodColorFile();
    }
    public void deleteMoodColor(int currentIndex){
        MoodColor extraColor = getColorList().get(currentIndex);
        getColorList().remove(extraColor);
        writeMoodColorFile();
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